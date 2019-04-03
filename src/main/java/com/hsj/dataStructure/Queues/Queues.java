package com.hsj.dataStructure.Queues;

import com.hsj.dataStructure.string.MyString;

/**
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/11.
 * @date 2019/2/12
 */
@SuppressWarnings("all")
public class Queues<E> implements IQueues<E> {
    private MyString<E> myString;

    /**
     * 指定容量大小为capacity的队列
     * @param capacity 容量大小
     */
    public Queues(int capacity){
        myString = new MyString<>(capacity);
    }

    /**
     * 创建一个容量大小为10的队列容器
     */
    public Queues(){
        this(10);
    }
    /**
     * 向队列添加元素
     *
     * @param e 添加的元素
     * @throws IllegalAccessException
     */
    @Override
    public void add(E e) throws IllegalAccessException {
        myString.addLast(e);
    }

    /**
     * 是否为空队列
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 得到队列中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return myString.getSize();
    }

    /**
     * 检索队列投，但不删除队列头
     *
     * @return
     */
    @Override
    public E element() throws IllegalAccessException {
        return myString.getFrist();
    }

    /**
     * <p>从队列中删除元素<p/>
     * @return
     * @throws IllegalAccessException
     */
    public E pop() throws IllegalAccessException {
        return myString.removeFrist();
    }
}
