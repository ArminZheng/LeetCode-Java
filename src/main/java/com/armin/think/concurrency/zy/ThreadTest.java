package com.armin.think.concurrency.zy;

/**
 * 软件方面，高并发系统，异步+回调等生产需求
 *
 * @author zy
 * @version 2021/12/3
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();

        Thread a = new Thread(() -> {
            synchronized (o) { // 这时 o 就是一个Monitor对象；
                // monitor对象会和Java对象一同创建并销毁，他的底层是由C++来实现的
                // monitor其实就是一种同步机制，他的义务是保证同一时刻只有一个线程可以访问被保护的数据和代码
                // jvm中同步是基于进入和退出监视器对象（monitor 管程对象）来实现的，每个对象实例都会有一个monitor对象
                // 临界区 的概念
            }
            System.out.println(Thread.currentThread().getName() + "start\t" + Thread.currentThread().isDaemon());
            while (true) ;
        }, "a");
        // 守护线程是一种特殊的线程，在后台默默的完成一些系统性的服务，比如垃圾回收线程
        a.setDaemon(true); // 设置守护线程需要在start()方法之前进行
        a.start();
        // 用户线程是系统的工作线程，他会完成这个程序需要完成的业务操作
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "start\t" + Thread.currentThread().isDaemon());
    }
}
