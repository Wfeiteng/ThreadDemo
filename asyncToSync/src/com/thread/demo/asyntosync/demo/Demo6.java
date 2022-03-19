package com.thread.demo.asyntosync.demo;

import com.thread.demo.asyntosync.template.BaseDemo;

import java.util.concurrent.locks.LockSupport;

public class Demo6 extends BaseDemo {

    //3.结果返回后进行回调，解除阻塞
    @Override
    public void callBack(long resp) {
        System.out.println("返回值:" + resp);
        LockSupport.unpark(Thread.currentThread());
    }
    // 堵塞
// LOckSupport.park();
}
