package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.BaseDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo5 extends BaseDemo {
    private CyclicBarrier barrier = new CyclicBarrier(2);
    @Override
    public void callBack(long resp) {
        System.out.println("调用结果");
        System.out.println(resp);
        System.out.println("调用结束");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        demo.call();
        try {
            demo.barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
