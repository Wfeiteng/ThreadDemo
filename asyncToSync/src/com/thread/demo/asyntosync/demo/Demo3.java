package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.AsyncCall;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Demo3 {
    AsyncCall asyncCall = new AsyncCall();

    public Future<Long> call() {
        Future<Long> resp = asyncCall.futureCall();
        asyncCall.shutDown();
        return resp;
    }

    public static void main(String[] args) {
        Demo3 demo = new Demo3();
        System.out.println("发起调用");
        Future<Long> resp = demo.call();
        System.out.println("返回结果");
        // while 应该可以去除
     //   while (!resp.isDone() && !resp.isCancelled()) ;
        try {
            System.out.println(resp.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }

}
