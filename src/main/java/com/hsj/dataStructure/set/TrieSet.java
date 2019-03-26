package com.hsj.dataStructure.set;

import com.hsj.dataStructure.Trie.Trie;
import com.hsj.dataStructure.set.iset.Set;

/**
 * <p>基于Trie实现的集合，由于Trie实现的类型是字符类型，所有这个Trie也是字符类型</p>
 * Created by 黄仕杰 on 2019/2/28.
 */
public class TrieSet implements Set{
    private Trie trie;
    public TrieSet(){
        trie = new Trie();
    }
    @Override
    public void add(Object o) {
        trie.add((String) o);
    }

    @Override
    public int getSize() {
        return trie.getSize();
    }

    @Override
    public boolean isEmpty() {
        return trie.getSize()==0;
    }

    @Override
    public void remove(Object o) {
        trie.remove((String) o);
    }

    @Override
    public boolean contains(Object o) {
        return trie.contains((String) o);
    }
}
