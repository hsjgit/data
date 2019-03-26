package com.hsj.dataStructure.heap;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 最大堆
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/26.
 * @date 2019/2/26
 */
public class MaxHeap<E extends Comparable<E>> {
    private List<E> list;

    /**
     * 构造一个指定大小的最大二叉堆
     * @param capacity 容量大小
     */
    public MaxHeap(int capacity){
        list = new ArrayList<>(capacity);
    }

    /**
     * 构建一个默认大小的最大二叉堆，默认大小为 ArrayList 的默认大小
     */
    public MaxHeap(){
        list = new ArrayList<>();
    }
    public int getSize(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public boolean contains(E e){
        return list.contains(e);
    }

    /**
     * 返回节点索引为i的父亲节点
     * @param index 需要检索的接节点
     * @return
     */
    public int parent(int index) throws IllegalAccessException {
        if (index==0){
            throw new IllegalAccessException("index-0 doesn't have parent.");
        }
        return (index-1)/2;
    }

    /**
     * 返回节点为 i 的左孩子的节点索引
     * @param i
     * @return
     */
    public int left(int i){
        return i*2+1;
    }
    /**
     * 返回节点为 i 的右孩子的节点索引
     * @param i
     * @return
     */
    public int rigth(int i){
        return i*2+2;
    }
    public  void add(E e) throws IllegalAccessException {
        list.add(e);
        siftup(list.size()-1);
    }

    private void siftup(int i) throws IllegalAccessException {
        while (i>0&&list.get(i).compareTo(list.get(parent(i)))>0){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public E finMax() throws IllegalAccessException {
        if (list.size()==0){
            throw new IllegalAccessException("have doesn't data");
        }
        return list.get(0);
    }
    public E extractMax() throws IllegalAccessException {
        E e=finMax();
        swap(0,list.size()-1);
        list.remove(list.size()-1);
        siftdown(0);
        return e;
    }

    private void siftdown(int i) {
        while (left(i)<list.size()){
            int j = left(i);
            if (j+1<list.size()&&list.get(j+1).compareTo(list.get(j))>0){
                j = rigth(i);
            }
            if (list.get(i).compareTo(list.get(j))>0){
                break;
            }else {
                swap(i,j);
                i=j;
            }
        }
    }
    private void swap(int i,int j){
        E e = list.get(i);
        list.set(i, list.get(j));
        list.set(j, e);
    }

    public static void main(String[] args) throws IllegalAccessException {
    }

}
