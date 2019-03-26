package com.hsj.dataStructure.realizationmap.map;

/**
 * Created by 黄仕杰 on 2019/2/25.
 */
public interface Map<K extends Comparable<K>,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue) throws IllegalAccessException;
    int getSize();
    boolean isEmpty();
}
