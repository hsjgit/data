package com.hsj.dataStructure.hash;
import java.util.TreeMap;

/**
 * <p>java8 的HashMap对于hash冲突刚开始是是用链表选址的方法解决，当链表达到的平均长度达到一定值时，此时的链表会变成一个红黑树<p/>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/3/20.
 */
public class HashTable<K,V> {
    private TreeMap<K, V>[] treeMap;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        treeMap = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            treeMap[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(16);
    }

    public int getSize() {
        return size;
    }

    private int hash(K k) {
        return k.hashCode();
    }

    public void put(K k, V v) {
        int index = hash(k);
        treeMap[index].put(k, v);
    }

    public V get(K k) {
        int index = hash(k);
        return treeMap[index].get(k);
    }

    public V remove(K k) {
        int index = hash(k);
        return treeMap[index].remove(k);
    }
}