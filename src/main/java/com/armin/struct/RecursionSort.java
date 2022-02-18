package com.armin.struct;

public class RecursionSort {
    // https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
    public static void main(String[] args) {
        int[] arr = {5, 54, 12, 78, 45, 9, 82, 62, 55, 8, 0, 6, -8, 101};
        RecursionSort p = new RecursionSort();
        p.mergesort(arr, 0, arr.length - 1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        // -8 0 5 6 8 9 12 45 54 55 62 78 82 101
    }

    /*将数组递归分为多个子数组，在依次排序合并*/
    public void mergesort(int[] arr, int left, int right) { // 0 2
        if (left < right) {
            int center = (left + right) >> 1;
            mergesort(arr, left, center); // 左右两边相差一位时，是最后一次运行 如 0 1 2
            mergesort(arr, center + 1, right);
            merge(arr, left, center, right);
        }
    }

    public static void merge(int[] A, int l, int c, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = c + 1;
        while (p1 <= c && p2 <= r) {
            help[i++] = A[p1] <= A[p2] ? A[p1++] : A[p2++];
        }
        while (p1 <= c) {
            help[i++] = A[p1++];
        }
        while (p2 <= r) {
            help[i++] = A[p2++];
        }
        for (i = 0; i < help.length; i++) {
            A[l+i] = help[i];
        }
    }
}
