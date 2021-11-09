package com.armin.nowcoder.hw;

import java.util.Scanner;

/**
 * 质数因子
 *
 * @author AZ
 * @since 2021-11-01
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
}
