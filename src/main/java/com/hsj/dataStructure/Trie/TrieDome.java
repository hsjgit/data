package com.hsj.dataStructure.Trie;


import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by 黄仕杰 on 2019/2/28.
 */
public class TrieDome {
    private class Node {
        private boolean iswords;
        private char aChar;
        private TreeMap<Character, Set<Node>> next;

        public Node(boolean iswords) {
            next = new TreeMap<>();
            this.iswords = iswords;
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;
    public TrieDome(){
        root = new Node();
        size = 0;
    }

    public void add(String s) {
        add(root,s);
    }

    private Node add(Node node, String s) {
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (node.next.get(c) == null) {
                node.next.put(c, new TreeSet<>());
                node.aChar = c;
            }
        }
        return null;

    }
}
