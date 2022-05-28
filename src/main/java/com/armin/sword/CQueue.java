package com.armin.sword;

import java.util.*;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        // only Integer boxed type
        Integer[] num = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, num);

        int[] ints = new int[]{1,2,3,4,5,6};
        // Cannot resolve method 'addAll(java.util.ArrayList<java.lang.Integer>, int[])'
        // ArrayList<Integer> integers = new ArrayList<>();
        // Collections.addAll(integers, ints);

        // use Stream
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());

        // run slower
        int[] res = collect.stream().mapToInt(Integer::intValue).toArray();
        // faster little
        // int[] result = new int[list.size()];
        // AtomicInteger i = new AtomicInteger();
        // list.forEach(e -> result[i.getAndIncrement()] = e);
    }
}
