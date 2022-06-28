package com.armin.lc;

/**
 * MinCost
 *
 * @author zy
 * @since 2022.06.25
 */
public class MinCost {

    public static void main(String[] args) {
        MinCost minCost = new MinCost();
        int i = minCost.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println("i = " + i);
    }

    public int minCost(int[][] costs) {
        // 做标记: 两个数组存 最小坐标 第二小坐标 (列值)
        int length = costs.length;
        int[] mins = new int[length];
        int[] seconds = new int[length];
        int[] indexs = new int[length];
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE, second = min, index = 3;
            for (int j = 0; j < 3; j++) {
                int process = costs[i][j];
                // second = min;
                min = Math.min(process, min);
                if (min != second) { // 未变的次数, 第一次绝对会变
                    second = min;
                    index--;
                }
            }
            indexs[i] = index;
            mins[i] = min;
            seconds[i] = second;
        }
        int temp = -1,sum = 0,present = 0;
        for (int i = 0; i < length; i++) {
            present = indexs[i];
            if (temp == present) {
                sum += Math.min(seconds[i], seconds[i - 1]);
            } else {
                sum += mins[i];
            }
            temp = present;
        }
        return sum;
    }
}
