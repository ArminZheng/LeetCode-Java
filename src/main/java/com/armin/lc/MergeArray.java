package com.armin.lc;

public class MergeArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int[] help = new int[m + n];
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while (i < m + n && i1 < m && i2 < n) {
            help[i++] = A[i1] > B[i2] ? B[i2++] : A[i1++];
        }
        while (i1 < m) {
            help[i++] = A[i1++];
        }
        while (i2 < n) {
            help[i++] = B[i2++];
        }

        int i3 = 0;
        while (i3 < m + n) {
            A[i3] = help[i3++];
        }
    }
}
