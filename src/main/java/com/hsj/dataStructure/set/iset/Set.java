package com.hsj.dataStructure.set.iset;

/**
 * Created by 黄仕杰 on 2019/2/19.
 */
public interface Set<E> {
    public void add(E e);
    public int getSize();
    public boolean isEmpty();
    public void remove(E e);
    public boolean contains(E e);


}
