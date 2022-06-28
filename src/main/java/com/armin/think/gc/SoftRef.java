package com.armin.think.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用：
 *
 * <p>-Xmx20m -XX:+PrintGCDetails -verbose:gc
 *
 * @author zy
 * @since 2022.06.28
 */
public class SoftRef {

    public static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        // normal();
        // soft();
        // softReferenceQueue();
        weak();
    }

    static void normal() {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4MB]);
        }
    }

    static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB]);
            System.out.println(reference.get());
            list.add(reference);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            // 软引用本身也占内存
            System.out.println(ref.get());
        }
    }

    static void softReferenceQueue() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        // 引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            // 关联引用队列，关联 软引用数组 被回收时，自己就会加入到 软引用队列 去
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(reference.get());
            list.add(reference);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        Reference<? extends byte[]> poll = queue.poll();
        // 手动挡
        while (poll != null) {
            list.remove(poll);
            // 注意！！poll的同时，ReferenceQueue自身也会移除引用对象
            poll = queue.poll();
        }
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }

    static void weak() {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> reference = new WeakReference<>(new byte[_4MB]);
            list.add(reference);
            for (WeakReference<byte[]> weakReference : list) {
                System.out.print(weakReference.get() + " ");
            }
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (WeakReference<byte[]> ref : list) {
            // 软引用本身也占内存
            System.out.println(ref.get());
        }
    }
}
