package com.armin.lc;

public class Nov11 {

    /**
     * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
     *
     * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
     *
     * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
     * @param args
     */
    public static void main(String[] args) {
        int n = 10 , k = 3;
        final int MOD = 1000000007;
        // 指在n为i%2时拥有j个逆序对的数组个数
        int[][] f = new int[2][k + 1];
        // 初始化，逆序对为0的时候只能为顺序数组，只有1个
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                int cur = i & 1, prev = cur ^ 1;
                // f[i][j] = f[i][j−1] − f[i−1][j−i] + f[i−1][j]
                // 这里使用两个一维数组模拟了二维数组
                f[cur][j] = (j - 1 >= 0 ? f[cur][j - 1] : 0) - (j - i >= 0 ? f[prev][j - i] : 0) + f[prev][j];

                if (f[cur][j] >= MOD) {
                    f[cur][j] -= MOD;
                }
                else if (f[cur][j] < 0) {
                    f[cur][j] += MOD;
                }
            }
        }
        System.out.println("f[n & 1][k] = " + f[n & 1][k]);
    }
}
