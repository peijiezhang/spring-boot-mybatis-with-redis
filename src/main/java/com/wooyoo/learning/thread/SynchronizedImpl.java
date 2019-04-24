package com.wooyoo.learning.thread;

public class SynchronizedImpl implements Runnable {
    private Object lock ;
    private int num ;
    public SynchronizedImpl(Object lock, int i) {
        this.lock = lock ;
        num = i ;
    }

    @Override
    public void run() {
        synchronized(lock){
            try {
                lock.wait();
                System.out.println("--- "+num);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        // 利用obj 的wait 方法实
        final  Object lock = new Object() ;
        new Thread(new SynchronizedImpl(lock,1)).start();
        new Thread(new SynchronizedImpl(lock,2)).start();
        try {
            // 等待另外两个线程进入wait状态
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.currentThread()======>"+Thread.currentThread());
        synchronized (lock){
            // 请将 lock.notify() 改成lock.notifyAll() 再执行观察二者区别 !!
            lock.notify();
        }
    }



}
