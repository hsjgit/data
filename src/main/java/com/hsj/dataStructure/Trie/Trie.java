package com.hsj.dataStructure.Trie;
import java.util.*;
import java.util.List;

/**
 * <p>结合映射，我们可以把Trie改成字典的形式，也就是一个查询出一个单词，然后再到映射中查询这个单词的意思</p>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/28.
 */
@SuppressWarnings("all")
public class Trie {
    private class Node {
        private char word;
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            next = new TreeMap<>();
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取trie树中存储的单词数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * <p>使用非递归的方法实现向trie树中添加字符串，待会在尝试递归的实现</p>
     * <p>一个节点代表的是一个字符</p>
     *
     * @param string
     */
    public void add(String string) {
        Node cre = root;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            //虽然在创建Trie对象的时候初始化了root，但是在root.next里什么也没添加，也就是在没有存放下一个元素的信息，
            //TreeMap存储的不是当前节点的值，而是下一个节点的值
            //通过c这个字符能不能查找到一个节点，c这个字符更相当于是字符到节点的一个映射关系
            if (cre.next.get(c) == null) {
                cre.next.put(c, new Node());
                cre.next.get(c).word = c;
            }
            //
            cre = cre.next.get(c);
        }
        //当添加到最后一个字符后，什么情况下把这个字符设置为结束的标准？
        //有种情况是之前就已经存储过这个单词，我们再存一遍只是相当于遍历一遍这个单词。
        // 只有当当前的所在的最后的字符标记isWord为false时才表示是一个新的单词。然后才执行size++
        if (!cre.isWord) {
            cre.isWord = true;
            size++;
        }
    }

    public boolean contains(String string) {
        Node cre = root;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (cre.next.get(c) != null) {
                cre = cre.next.get(c);
            } else {
                return false;
            }
        }
        return cre.isWord;
    }

    public void remove(String string) {
        if (contains(string)) {
            Node cre = root;
            for (int i = 0; i < string.length(); i++) {
                cre = cre.next.get(string.charAt(i));
            }
            cre.isWord = false;
            size--;
        }
    }

    public boolean prefix(String prefix) {
        Node cre = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cre.next.get(c) == null) {
                return false;
            }
        }
        return true;
    }
}