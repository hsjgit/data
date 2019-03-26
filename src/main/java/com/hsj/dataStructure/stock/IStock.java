package com.hsj.dataStructure.stock;

/**
 * 栈接口
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/11.
 * @date 2019/2/11
 */
public interface IStock<E> {
    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回栈中的元素个数
     * @return
     */
    int getSize();

    /**
     * 如栈操作
     * @param e
     * @throws IllegalAccessException
     */
    void push(E e)throws IllegalAccessException;

    /**
     * 出栈操作
     * @return
     * @throws IllegalAccessException
     */
    E pop()throws IllegalAccessException;

    /**
     * 得到栈顶的元素，但是不删除栈顶元素
     * @return
     * @throws IllegalAccessException
     */
    E peek()throws IllegalAccessException;

    /**
     * 返回一个对象栈此栈的位置,如果存在返回元素位置，否则返回-1
     * @param e
     * @return
     */
    int search(E e);
}
