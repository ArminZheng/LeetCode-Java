package com.armin.think.tuple;

/**
 * TupleMain
 *
 * @author zy
 * @version 2022/4/9
 */
public class TupleMain {
    public static void main(String[] args) {
        TwoTuple<Integer, Double> twoTuple = new TwoTuple<>(3, 3.3);
        System.out.println("twoTuple => " + twoTuple);
        ThreeTuple<Integer, Double, Boolean> threeTupleTuple = new ThreeTuple<>(3, 3.3, true);
        System.out.println("threeTupleTuple => " + threeTupleTuple);
    }
}
