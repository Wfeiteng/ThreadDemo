package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.BaseDemo;

import java.util.concurrent.CountDownLatch;

public class Demo4 extends BaseDemo {
    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void callBack(long resp) {
        System.out.println("调用开始");
        System.out.println(resp);
        System.out.println("调用结束");
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        Demo4 demo = new Demo4();
        demo.call();
        try {
            demo.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
