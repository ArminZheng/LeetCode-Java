package com.armin.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列
 *
 * @author zy
 * @version 2022/4/18
 */
class CQueue {

    Deque<Integer> in, out;

    public CQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
            return out.pop();
        }
        if (in.isEmpty()) {
            return -1;
        }
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.pop();
    }
}
