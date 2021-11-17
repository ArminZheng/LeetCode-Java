package com.armin.lc;

import java.util.HashMap;
import java.util.Map;

public class Nov17 {

    /**
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     */
    public static void main(String[] args) {
        String[] s = {"zz", "zxyz", "xyji"};
        maxWordProduct(s);
    }

    public static void maxWordProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int t = 0, m = word.length();
            for (int i = 0; i < m; i++) {
                int u = word.charAt(i) - 'a';
                t |= (1 << u); // use | decide whether letter appears
            }
            if (!map.containsKey(t) || map.get(t) < m) {
                map.put(t, m);
            }
        }

        int ans = 0;
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) { // "&" and "==0" definite different
                    ans = Math.max(ans, map.get(i) * map.get(j));
                }
            }
        }
        System.out.println("ans = " + ans);
    }
}
