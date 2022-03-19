package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.BaseDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 extends BaseDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void callBack(long resp) {
        System.out.println("得到结果");
        System.out.println(resp);
        System.out.println("调用结束");
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        demo.call();
        demo.lock.lock();
        try {
            demo.condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            demo.lock.unlock();
        }
        System.out.println("主线程内容");
    }
}
