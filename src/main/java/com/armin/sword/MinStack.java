package com.armin.sword;

/**
 * MinStack
 *
 * @author zy
 * @version 2022/4/20
 */
public class MinStack {
    private Node head;

    public MinStack() {}

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(99);
        obj.pop();
        System.out.println("obj.top() = " + obj.top());
        System.out.println("obj.min() = " + obj.min());
    }

    public void push(int x) {
        if (head == null) head = new Node(x, x, null);
        else head = new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {
        if (head == null) return;
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
