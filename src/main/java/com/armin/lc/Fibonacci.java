package com.armin.lc;

import java.util.Random;

/**
 * 509.Fibonacci
 *
 * @author zy
 * @version 2022/4/11
 */
public class Fibonacci {

    public static void main(String[] args) {
        // 1 1 2 3 5 8 13
        final Fibonacci fibonacci = new Fibonacci();
        // [0,bound)
        int i = new Random().nextInt(10);
        System.out.println("i = " + i);
        System.out.println(fibonacci.fib(i));
    }

    private int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 | n == 2) return 1;
        int pre = 1, cur = 1;
        for (int i = 2; i < n; i++) {
            cur = cur + pre;
            pre = cur - pre;
        }
        return cur;
    }
}
