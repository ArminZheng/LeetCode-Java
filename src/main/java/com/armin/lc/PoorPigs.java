package com.armin.lc;

/**
 * @author zy
 * @version 2021/11/25
 */
public class PoorPigs {

    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 15, 60));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        double t = Math.log(buckets) / Math.log(minutesToTest/minutesToDie + 1);
        System.out.println("t = " + t);
        return (int) Math.ceil(t);
    }
}
