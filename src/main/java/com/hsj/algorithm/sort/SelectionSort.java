package com.hsj.algorithm.sort;

/**
 * 选择排序
 * @author 黄仕杰
 * @date 2019/07/03
 */
public class SelectionSort {
    public int[] selectSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    minIndex = j;
                    int temp;
                    temp = num[minIndex];
                    num[minIndex] = num[i];
                    num[i] = temp;
                }

            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[] n = {10, 9, 8, 7, 6, 5, 4, 3, 2, 2, 1, 1,};
        SelectionSort selectionSort = new SelectionSort();
        n = selectionSort.selectSort(n);
        for (int i : n) {
            System.out.print(i+" ");
        }
    }
}
