package com.hsj.dataStructure.Queues;

/**
 * 队列的模拟,循环队列
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/11.
 * @date 2019/2/11
 */
public interface IQueues<E> {
    /**
     * 向队列添加元素
     * @param e 添加的元素
     * @throws IllegalAccessException
     */
    void add(E e)throws IllegalAccessException;

    /**
     * 是否为空队列
     * @return
     */
    boolean isEmpty();

    /**
     * 得到队列中元素个数
     * @return
     */
    int getSize();

    /**
     * 检索队列头，但不删除队列头
     * @return
     */
    E element() throws IllegalAccessException;

}
