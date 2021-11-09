package com.armin.nowcoder.hw;
import java.util.*;

/**
 * 进制转换
 *
 * @author AZ
 */
public class HJ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String number = sc.next();
            int res = getDecimal(number.substring(2));
            System.out.println(res);
        }
    }
    public static int getDecimal(String number) {
        int res = 0;
        for(char c : number.toCharArray()){
            int tmp = 0;
            if(c>='0' && c<='9'){
                tmp = c -'0';
            } else if (c>='A' && c<='F'){
                tmp = c - 'A' + 10;
            } else if (c>='a' && c<='f'){
                tmp = c - 'a' + 10;
            }
            res = res * 16 + tmp;
        }
        return res;
    }
}