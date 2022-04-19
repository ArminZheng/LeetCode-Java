package com.armin.think.generics;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * StringJoiner 连接符 前缀 后缀
 *
 * @author zy
 * @version 2022/4/20
 */
public class StringJoinerGenerator {

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D"};
        StringJoiner stringJoiner = new StringJoiner(", ", "「", "」");
        for (String name : names) {
            stringJoiner.add(name);
        }
        System.out.println("stringJoiner = " + stringJoiner);

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
        System.out.println("desiredString = " + desiredString);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers =
                numbers.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
        System.out.println("commaSeparatedNumbers = " + commaSeparatedNumbers);
    }
}
