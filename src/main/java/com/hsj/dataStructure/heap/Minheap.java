package com.hsj.dataStructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小的堆的实现
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/26.
 * @date 2019/2/26
 */
public class Minheap<E extends Comparable<E>> {
    private List<E> list;

    /**
     * 构造初始容量为capacity大小的最小堆
     *
     * @param capacity
     */
    public Minheap(int capacity) {
        list = new ArrayList<>(capacity);
    }

    /**
     * 构造默认大小的最小堆
     */
    public Minheap() {
        list = new ArrayList<>();
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }

    /**
     * 检索元素e是否存在于本堆中，如果纯在返回true否则返回false
     *
     * @param e 检索的目标元素
     * @return
     */
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 判断这个最小堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 返回节点索引为i的父亲节点
     *
     * @param index 需要检索的接节点
     * @return
     */
    public int parent(int index) throws IllegalAccessException {
        if (index == 0) {
            throw new IllegalAccessException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回节点为 i 的左孩子的节点索引
     *
     * @param i
     * @return
     */
    public int left(int i) {
        return i * 2 + 1;
    }

    /**
     * 返回节点为 i 的右孩子的节点索引
     *
     * @param i
     * @return
     */
    public int rigth(int i) {
        return i * 2 + 2;
    }

    /**
     * 添加元素
     *
     * @param e 添加的元素
     * @throws IllegalAccessException
     */
    public void add(E e) throws IllegalAccessException {
        list.add(e);
        sitfUp(list.size() - 1);
    }

    /**
     * 上浮
     * @param i
     * @throws IllegalAccessException
     */
    private void sitfUp(int i) throws IllegalAccessException {
        while (i > 0 && list.get(i).compareTo(list.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public E finMin() {
        return list.get(0);
    }

    public E extractMin() {
        E e = finMin();
        swap(0, list.size() - 1);

        list.remove(list.size() - 1);
        siftDowm(0);
        return e;
    }

    /**
     * 下浮
     * @param i
     */
    private void siftDowm(int i) {
        while (left(i) < list.size()) {
            int j = left(i);

            if (j + 1 < list.size() && list.get(j).compareTo(list.get(j + 1)) > 0) {

                j = rigth(i);
            }
            if (list.get(i).compareTo(list.get(j)) < 0) {
                break;
            } else {
                swap(i, j);
                i = j;
            }

        }
    }

    private void swap(int i, int j) {
        E e = list.get(i);
        list.set(i, list.get(j));
        list.set(j, e);
    }
}