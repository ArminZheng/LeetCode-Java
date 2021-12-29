package com.armin.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllConcatenatedWordsInADict {

    public static void main(String[] args) {
        FindAllConcatenatedWordsInADict o = new FindAllConcatenatedWordsInADict();
        List<String> allConcatenatedWordsInADict = o.findAllConcatenatedWordsInADict(new String[]{"", "", "", ""});
        System.out.println("allConcatenatedWordsInADict = " + allConcatenatedWordsInADict);
    }

    Set<Long> set = new HashSet<>();
    int P = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (char c : words[i].toCharArray()) hash = hash * P + (c - 'a') + OFFSET;
            set.add(hash);
        }
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            if (check(s)) ans.add(s);
        }
        return ans;
    }

    boolean check(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (f[i] == -1) continue;
            long cur = 0;
            for (int j = i + 1; j <= n; j++) {
                cur = cur * P + (s.charAt(j - 1) - 'a') + OFFSET;
                if (set.contains(cur)) f[j] = Math.max(f[j], f[i] + 1);
                if (f[n] > 1) return true;
            }
        }
        return false;
    }
}