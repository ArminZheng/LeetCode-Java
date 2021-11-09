package com.armin.nowcoder.hw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author AZ
 * @since 2021-11-02
 */
public class ThreadPoolPractice {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2, //corePoolSize
                5,//maximumPoolSize
                1L,//keepAliveTime
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            //模拟10个用户来办理业务，每个用户就是来自外部的请求线程
            for (int i = 1; i <= 100; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务" + finalI);
                });
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }


    public void single() {
        ExecutorService threadpool = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                //使用了线程池之后，使用线程池来创建线程
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadpool.shutdown();   //（为确保关闭，将关闭方法放入到finally中）
        }
    }

    public static void Fixed() {
        //最多5个线程同时执行，从控制台中查看结果
        ExecutorService threadpool = Executors.newFixedThreadPool(5);   //创建一个固定的线程池的大小，（5个线程）

        try {
            for (int i = 0; i < 10; i++) {
                //使用了线程池之后，使用线程池来创建线程
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadpool.shutdown();   //（为确保关闭，将关闭方法放入到finally中）
        }
    }

    public static void cached() {
        ExecutorService threadpool = Executors.newCachedThreadPool();   //缓存池，可伸缩的， 遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 10; i++) {
                //使用了线程池之后，使用线程池来创建线程
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadpool.shutdown();   //（为确保关闭，将关闭方法放入到finally中）
        }
    }
}
