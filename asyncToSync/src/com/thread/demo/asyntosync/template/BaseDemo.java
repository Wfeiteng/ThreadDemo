package com.thread.demo.asyntosync.template;

public abstract class BaseDemo {
    protected AsyncCall asyncCall = new AsyncCall();
    public abstract void callBack(long resp);

    public void call(){
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }

}
