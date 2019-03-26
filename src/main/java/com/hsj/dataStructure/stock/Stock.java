package com.hsj.dataStructure.stock;

import com.hsj.dataStructure.string.MyString;



/**
 * 栈的模拟
 * 主要实现的就是一个
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/11.
 * @date 2019/2/11
 */
@SuppressWarnings("all")
public class Stock <E> implements IStock<E>{
    private MyString<E> myStrings;

    /**
     * 构造一个指定大小的栈空间
     * @param capacity
     */
    public Stock(int capacity){
        myStrings = new MyString(capacity);
    }

    /**
     * 构造一个默认大小为10的栈空间
     */
    public Stock(){
        this(10);
    }

    /**
     * 判断栈中是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return myStrings.getSize()==0;
    }

    /**
     * 得到栈中的元素
     * @return
     */
    @Override
    public int getSize(){
        return myStrings.getSize();
    }
    /**
     * 入栈操作
     * @param e
     * @throws IllegalAccessException
     */
    @Override
    public void push(E e) throws IllegalAccessException{
        myStrings.addLast(e);


    }

    /**
     * 出栈操作
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E pop() throws IllegalAccessException {
        return myStrings.removeLast();
    }

    /**
     * 返回栈顶的元素，而不是删除它
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E peek() throws IllegalAccessException {
       return myStrings.getValue(getSize() - 1);
    }
    @Override
    public int search(E e){

        return myStrings.fount(e);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", myStrings.getSize(), myStrings.getCapacity()));
        res.append("[");
        for (int i = 0; i < myStrings.getSize(); i++) {
            try {
                res.append(myStrings.getValue(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i != myStrings.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
