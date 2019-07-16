package com.hsj.algorithm.sort;

/**
 * <p>插入排序<p/>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/4/3.
 */
public class InsertionSort {
    public int[] inset(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j;
            for (j = i; j > 0 && num[j-1] > temp; j--) {
                num[j] = num[j - 1];
            }
            num[j] = temp;
        }
        return num;
    }
    public static void main(String[] args) {
        int[] n = {10, 9, 8, 7, 6, 5, 4, 3, 2, 2, 1, 1,};
        InsertionSort insertionSort = new InsertionSort();
        n = insertionSort.inset(n);
        for (int i : n) {
            System.out.print(i+" ");
        }
    }

}