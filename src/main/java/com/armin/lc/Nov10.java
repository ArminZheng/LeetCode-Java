package com.armin.lc;

public class Nov10 {
    /**
     * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄。他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
     * <p>
     * 当提莫攻击艾希，艾希的中毒状态正好持续 duration 秒。
     * <p>
     * 正式地讲，提莫在 t 发起发起攻击意味着艾希在时间区间 [t, t + duration - 1]（含 t 和 t + duration - 1）处于中毒状态。如果提莫在中毒影响结束 前 再次攻击，中毒状态计时器将会 重置 ，在新的攻击之后，中毒影响将会在 duration 秒后结束。
     * <p>
     * 给你一个 非递减 的整数数组 timeSeries ，其中 timeSeries[i] 表示提莫在 timeSeries[i] 秒时对艾希发起攻击，以及一个表示中毒持续时间的整数 duration 。
     * <p>
     * 返回艾希处于中毒状态的 总 秒数。
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int t = 0;
        for(int i = 0;i < timeSeries.length;i++){
            int e = timeSeries[i+1] - timeSeries[i];
            // t += duration < e ? duration : e;
            t += Math.min(e,duration);
        }
        t += duration;
        return 0;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1,2};
        int duration = 3;
        int ans = 0, last = -1;
        for (int s : timeSeries) {
            int e = (s-1) + duration; // 本应该持续的时间点
            ans += (last < s) ? duration : e - last; // 这次持续的点减去上次应该持续的点，为增量
            last = e; // last更新为本应该持续的点
        }
        System.out.println("ans = " + ans);
    }
}
