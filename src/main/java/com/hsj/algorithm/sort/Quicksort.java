package com.hsj.algorithm.sort;

/**
 * <p>快速排序<p/>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/3/23.
 */
public class Quicksort {
    public  void sort(int[] ts) {
        sort(ts, 0, ts.length-1);
    }

    private  void sort(int[] ts, int left, int right) {
        if (left > right) {
            return;
        }
        int lef = ts[left];
        int l=left;
        int r=right;
        int temp;
        while (l != r) {
            //顺学很重要，一定要先从右边开始
            //现在开始交换从右边开始
            while (ts[r] >= lef && r > l) {
                r--;
            }
            while (ts[l] <= lef && r > l) {
                l++;
            }
            //当右边和左边的数都遇到了需要交换的的时候
            if (l < r) {
                //交换
                temp = ts[l];
                ts[l] = ts[r];
                ts[r] = temp;
            }
        }
        //当l和r相等时把最开始左边的数和吃屎ts[i]交换
        ts[left] = ts[l];
        ts[l] = lef;
        //一遍结束，接下来是把这个数字以l分成两份
        sort(ts, left, l - 1);
        sort(ts, l + 1, right);
    }

    public static void main(String[] args) {
        Quicksort q = new Quicksort();
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1,89,56,85};
        q.sort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
