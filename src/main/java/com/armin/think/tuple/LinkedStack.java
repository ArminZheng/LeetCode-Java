package com.armin.think.tuple;

/**
 * Stack Structure
 *
 * @author zy
 * @version 2022/4/9
 */
public final class LinkedStack<T> {

    private Node<T> top = new Node<>(); // End sentinel

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phaser's on stun!".split(" ")) lss.push(s);
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
}
