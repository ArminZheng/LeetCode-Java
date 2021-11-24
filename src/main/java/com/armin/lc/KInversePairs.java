package com.armin.lc;

public class KInversePairs {
    static final int MOD = (int) (1e9 + 7);

    /**
     * 629：给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
     * <p>
     * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
     * <p>
     * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 1000, k = 1000;
        // extracted(n, k);
        int i = kInversePairs(n, k);
        System.out.println("i = " + i);
    }
    // 【1】【2】【3】【4】  ===>  5 【1】【2】【3】【4】
    // 列：j-(i-i) ===> j-(i-1) = j-i+1 总共 i 种
    private static int extracted(int n, int k) {
        // k 可以是一个远远大于 n 的数，j 同理可以远大于 i
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-i+1] // 这里最后一列是指新增的数只能插到第一位之前，总共 n-1（之前的数）+1
        // dp[i][j+1] = dp[i-1][j+1] + dp[i-1][j] + ... + dp[i-1][j-i+2]
        // dp[i][j+1] - dp[i][j] = dp[i-1][j+1] - dp[i-1][j-i+1]
        // dp[i][j+1] = dp[i-1][j+1] - dp[i-1][j-i+1] + dp[i][j]
        /* 最终：
         dp[i][j] = dp[i-1][j] - dp[i-1][j-i] + dp[i][j-1]
         */
        // dp[cur][j] = dp[pre][j] - dp[pre][j-i] + dp[cur][j-1]
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            int cur = i & 1, prev = cur ^ 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) {
                    // 当 j 大于 i 时，证明了光靠新增的 n 增加的 n 个逆序数还不够，这个时候就需要引入之前的逆序数个数来推出后面的逆序数
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return (int) dp[n][k];
    }
    // 状态压缩优化版
    public static int kInversePairs(int n, int k) {
        int[][] dp = new int[2][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cur = i & 1, pre = cur ^ 1;
                // dp[cur][j] = dp[pre][j] - dp[pre][j-i] + dp[cur][j-1]
                dp[cur][j] = dp[pre][j] - (j-i >= 0 ? dp[pre][j-i] : 0) + (j-1>=0 ? dp[cur][j-1] : 0);
                // 不能这么写
                // dp[cur][j] += MOD;
                // dp[cur][j] %= MOD;
                // if (dp[cur][j] < 0) {
                //     System.out.println("dp["+cur+"]["+j+"] = " + dp[cur][j]);
                // }
                if (dp[cur][j] >= MOD) {
                    dp[cur][j] -= MOD;
                } else if (dp[cur][j] < 0) {
                    dp[cur][j] += MOD;
                }
            }
        }
        return dp[n & 1][k];
    }
}
