package com.armin.think.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * Test
 *
 * @author zy
 * @version 2022/4/10
 */
public class Book {

    boolean checkOut;

    public Book(boolean checkOut) {
        this.checkOut = checkOut;
    }

    void checkIn() {
        checkOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkOut) System.out.println("error check out");
        super.finalize();
    }
    static class BookStore {
        public static void main(String[] args) {
            Book test = new Book(true);
            test.checkIn();
            new Book(true);
            System.gc();

            double x = 10E9; // 科学计数法 10x10^9 10,000,000,000
            double y = 10 * Math.pow(10, 9); // 正常java里表达次方
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println(y == x);

            Map<String, String> map = new HashMap<>();
            map.put("1", "1");
            // map.put("hhh", null); if exist return null
            String defaultValue = map.getOrDefault("hhh", "没有");
            System.out.println(defaultValue); // return 没有

            // 范型 P357 内部类 P190
        }
    }
}

