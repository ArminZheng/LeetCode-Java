package com.armin.lc;

import java.util.Arrays;

/**
 * 322.CoinChange
 *
 * @author zy
 * @version 2022/4/21
 */
public class CoinChange {

    int[] memo;
    int[] dp;

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        // System.out.println(coinChange.coinChangeMemo(new int[] {2}, 3));
        System.out.println(coinChange.coinChange(new int[]{1, 2, 3, 5}, 18));
    }

    /**
     * dp 数组的迭代解法
     *
     * <p>状态转移方程：min{dp(n-coin) + 1 | coin in coins}, n>0; 0, n=0; -1, n<0;
     *
     * @param coins  面额
     * @param amount 需要凑的金额
     * @return 总共几张
     */
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1]; // 保持 dp[] 下标最大值 等于 amount。多出了一个坐标0
        Arrays.fill(dp, amount + 1); // 最小面额为1，也就是最多amount张得到amount元，这里写 amount+1 是取不到的 == infinity

        dp[0] = 0;
        for (int price = 1; price < dp.length; price++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 金额 低于 最小面额 跳过
                if (price - coin < 0) {
                    continue;
                }
                dp[price] = Math.min(dp[price], 1 + dp[price - coin]); // 复用
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 带备忘录的递归
     *
     * @param coins  面额
     * @param amount 需要凑的金额
     * @return 总共几张
     */
    public int coinChangeMemo(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1024);

        // Collections.fill(list, 0);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != -1024) return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem < 0) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
