package com.armin.think.concurrency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zy
 * @version 2021/11/30
 */
public class BasicThreads {
    public static void main(String[] args) throws ParseException {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = format1.parse("2021-12-31 23:59:59");
        System.out.println("parse1 = " + parse);
        SimpleDateFormat format2 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        Date parse2 = format2.parse("2021-12-31 23:59:59");
        System.out.println("parse1 = " + parse2);
        SimpleDateFormat format3 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date parse3 = format3.parse("2021-12-31 23:59:59");
        System.out.println("parse1 = " + parse3);
    }
}
