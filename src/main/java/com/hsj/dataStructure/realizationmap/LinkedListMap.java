package com.hsj.dataStructure.realizationmap;
import com.hsj.dataStructure.realizationmap.map.Map;

/**
 * 用链表实现的映射
 * Created by 黄仕杰 on 2019/2/25.
 */
@SuppressWarnings("all")
public class LinkedListMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        private K key;
        private V value;
        private Node next;
        public Node(K key,V value,Node node){
            this.key = key;
            this.value = value;
            this.next = node;
        }
        public Node(K key){
            this(key, null, null);
        }
        public Node(){
            this(null, null, null);
        }
    }
    private Node dummyHead;
    private int size;
    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    private Node getNode(K key){
        Node cre = dummyHead.next;
        while (cre!=null){
            if (cre.key.equals(key)){
                return cre;
            }
            cre = cre.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node==null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next!=null){
            if (prev.next.key.equals(key)){
                break;
            }else {
                prev = prev.next;
            }
        }
        if (prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node!=null?node.value:null;
    }

    @Override
    public void set(K key, V NewValue) throws IllegalAccessException {
        Node node = getNode(key);
        if (node!=null){
            node.value = NewValue;
        }else {
            throw new IllegalAccessException(key + "doesn't exits!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String []args){
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("huangshijie","huang");
        map.add("xiaoyao","xaio");
        map.add("node","n");
        System.out.println(map.remove("huangshijie"));
        System.out.println("---------------------------");
        System.out.println(map.get("huangshijie"));
        System.out.println(map.get("xiaoyao"));
        System.out.println(map.get("node"));
    }
}
