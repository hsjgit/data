package com.hsj.algorithm.sort;


/**
 * 冒泡排序
 * @author 黄仕杰
 * @date 2019/0703
 */
public class BubbleSort {
    public int[] bubble(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i ; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] n = {10, 9, 8, 7, 6, 5, 4, 3, 2, 2, 1, 1,};
        BubbleSort bubbleSort = new BubbleSort();
        n = bubbleSort.bubble(n);
        for (int i : n) {
            System.out.print(i+" ");
        }
    }
}
