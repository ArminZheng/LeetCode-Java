package com.armin.think.concurrency;

/**
 * @author zy
 * @version 2021/11/30
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
