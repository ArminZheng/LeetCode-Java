package com.armin.think.gc;

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
}

class BookStore {
    public static void main(String[] args) {
        Book test = new Book(true);
        test.checkIn();
        new Book(true);
        System.gc();
    }
}
