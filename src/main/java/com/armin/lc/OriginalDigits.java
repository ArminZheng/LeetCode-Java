package com.armin.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @version 2021/11/24
 */
public class OriginalDigits {

    /**
     * 423：给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("originalDigits(\"jj\") = " + originalDigits("jj"));
    }

    public static String originalDigits(String s) {

        return "jj";
    }

    public String 官方题解(String s) {
        /*
        方法一：依次确定每一个数字的次数
        思路与算法

        首先我们可以统计每个字母分别在哪些数字中出现：

        字母	数字
        e	0 1 3 5 7 8 9
        f	4 5
        g	8
        h	3 8
        i	5 6 8 9
        n	1 7 9
        o	0 1 2 4
        r	0 3 4
        s	6 7
        t	2 3 8
        u	4
        v	5 7
        w	2
        x	6
        z	0
        可以发现，\text{z, w, u, x, g}z, w, u, x, g 都只在一个数字中，即 0, 2, 4, 6, 80,2,4,6,8 中出现。因此我们可以使用一个哈希表统计每个字母出现的次数，那么 \text{z, w, u, x, g}z, w, u, x, g 出现的次数，即分别为 0, 2, 4, 6, 80,2,4,6,8 出现的次数。

        随后我们可以注意那些只在两个数字中出现的字符：

        \text{h}h 只在 3, 83,8 中出现。由于我们已经知道了 88 出现的次数，因此可以计算出 33 出现的次数。

        \text{f}f 只在 4, 54,5 中出现。由于我们已经知道了 44 出现的次数，因此可以计算出 55 出现的次数。

        \text{s}s 只在 6, 76,7 中出现。由于我们已经知道了 66 出现的次数，因此可以计算出 77 出现的次数。

        此时，我们还剩下 11 和 99 的出现次数没有求出：

        \text{o}o 只在 0, 1, 2, 40,1,2,4 中出现，由于我们已经知道了 0, 2, 40,2,4 出现的次数，因此可以计算出 11 出现的次数。
        最后的 99 就可以通过 \text{n, i, e}n, i, e 中的任一字符计算得到了。这里推荐使用 \text{i}i 进行计算，因为 \text{n}n 在 99 中出现了 22 次，\text{e}e 在 33 中出现了 22 次，容易在计算中遗漏。

        当我们统计完每个数字出现的次数后，我们按照升序将它们进行拼接即可。
         */
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }
}
