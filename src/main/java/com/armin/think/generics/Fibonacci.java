package com.armin.think.generics;

/**
 * Fibonacci
 *
 * @author zy
 * @version 2022/4/11
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if ((n < 2)) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        final Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(fibonacci.next() + " ");
        }
    }
}
