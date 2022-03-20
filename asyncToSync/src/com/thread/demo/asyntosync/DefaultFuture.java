package com.thread.demo.asyntosync;

public class DefaultFuture {
    private RpcResponse rpcResponse;
    private volatile boolean isSucceed = false;
    private final Object object = new Object();

    public RpcResponse getResponse(int timeout) {
        synchronized (object) {
            while (!isSucceed) {
                try {
                    //wait
                    object.wait(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return rpcResponse;
        }
    }

    // 远程调用结果，返回值;唤起堵塞的线程;
    public void setResponse(RpcResponse response) {
        if (isSucceed) {
            return;
        }
        synchronized (object) {
            this.rpcResponse = response;
            this.isSucceed = true;
            //notiy
            object.notify();
        }
    }

    public static class RpcResponse{
        //
    }
}
// https://juejin.cn/post/6844903684573265927 customer-rpc