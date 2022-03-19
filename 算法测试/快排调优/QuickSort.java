package com.heaboy.Test;

/**
 * @author yenanren
 * @date 2022/3/11 0011
 * @Description
 */
public class QuickSort {


    public static void quickSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        if (l > r - 60) {
            //插入排序
            //O(N^2),样本量小的时候,跑得快
            return;
        }
        swap(arr, l + (int) Math.random() * (r - l + 1), r);
        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0] - 1);// <区
        quickSort(arr, p[1] + 1, r);// >区
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;//  <区右边界
        int more = R;// >区左边界
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int l, int r) {

    }
}
