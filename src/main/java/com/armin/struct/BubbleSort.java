package com.armin.struct;

/**
 * BubbleSort
 *
 * @author zy
 * @version 2022/2/18
 */
public class BubbleSort {
  public static void main(String[] args) {
    // (i + 1) < i 成立条件
    int i = Integer.MAX_VALUE;
    System.out.println((i + 1) < i); // true 超过最大值后为负数
    // 冒泡排序
    int[] arr = {5, 54, 12, 78, 45, 9, 82, 62, 55, 8, 0, 6, -8, 101};
    bubbleSort(arr);
    for (int j : arr) {
      System.out.print(j + " ");
    }
  }

  public static void bubbleSort(int[] arr) {

    int temp; // 临时变量
    boolean flag; // 是否交换的标志

    for (int i = 0; i < arr.length - 1; i++) { // 一共遍历 arr.length-1 次
      // 每次遍历都置为true，判断后面的元素是否发生了交换
      flag = true;

      for (int j = arr.length - 1; j > i; j--) { // 选出该趟排序的最小值往前移动
        if (arr[j] < arr[j - 1]) {
          temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          flag = false; // 只要有发生了交换，flag就置为false
        }
      }
      // 如果没有发生交换，说明所有的元素已经有序，提前中止
      if (flag) break;
    }
  }
}
