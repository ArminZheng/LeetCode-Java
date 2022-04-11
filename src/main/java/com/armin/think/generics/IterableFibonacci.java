package com.armin.think.generics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * IterableFibonacci
 *
 * @author zy
 * @version 2022/4/11
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");

        // Iterator var1 = (new IterableFibonacci(18)).iterator();
        //
        // while(var1.hasNext()) {
        //     int i = (Integer)var1.next();
        //     System.out.print(i + " ");
        // }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }
}
