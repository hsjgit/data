package com.hsj.dataStructure.set;

import com.hsj.dataStructure.Tree.BST;
import com.hsj.dataStructure.set.iset.Set;

/**
 * Created by 黄仕杰 on 2019/2/19.
 */
public class BSTSte<E extends Comparable<E>> implements Set<E> {
    private BST<E> tree;
    public BSTSte() {
        tree = new BST<>();
    }

    @Override
    public void add(E e) {
        tree.add(e);
    }

    @Override
    public int getSize() {
        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }
}
