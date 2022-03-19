package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.BaseDemo;

public class Demo1 extends BaseDemo {
    private final Object lock = new Object();

    @Override
    public void callBack(long resp) {
        System.out.println("得到结果");
        // mock handler data
        System.out.println(resp);
        System.out.println("调用结束");
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        // 调用
        demo.call();
        synchronized (demo.lock){
            try{
                demo.lock.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("主线程内容");
    }
}
