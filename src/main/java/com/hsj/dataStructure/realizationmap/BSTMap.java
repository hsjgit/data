package com.hsj.dataStructure.realizationmap;
import com.hsj.dataStructure.realizationmap.map.Map;
/**
 * 利用二分搜索树实现的映射
 * Created by 黄仕杰 on 2019/2/25.
 */
@SuppressWarnings("all")
public class BSTMap<K extends Comparable<K>, V>implements Map<K,V> {
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BSTMap(){
        root = null;
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node add(Node node,K key,V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            if (key.compareTo(node.key) > 0) {
                node.right = add(node.right, key, value);
            }else {
                //相等的话就更新一下
                node.value = value;
            }
        }
        return node;
    }

    /**
     * 得到最小值
     * @return 返回最小值
     */
    public V getMin(){
        return getMin(root).value;
    }
    private Node getMin(Node node){
        if (node.left==null){
            return node;
        }else {
            return getMin(node.left);
        }
    }
    /**
     * 得到最大值
     * @return 返回大值
     */
    public V getMax(){
        return getMax(root).value;
    }
    private Node getMax(Node node){
        if (node.right==null){
            return node;
        }else {
            return getMin(node.right);
        }
    }

    /**
     * 删除以node为根节点的最小值，并返回删除的value
     * @return 返回删除最小后的新的节点
     */
    public V removeMin(){
        V value=getMin();
        root = removeMin(root);
        return value;
    }
    private Node removeMin(Node node){
        if (node.left==null){
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }
    /**
     * 删除以node为根节点的大值，并返回删除的value
     * @return 返回删除最大后的新的节点
     */
    public V removeMax(){
        V value=getMax();
        root = removeMax(root);
        return value;
    }
    private Node removeMax(Node node){
        if (node.right==null){
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }
    @Override
    public V remove(K key) {
        V value = get(key);
        root=remove(root,key);
        return value;
    }
    private Node remove(Node node,K key){
        if (node==null){
            return null;
        }else {
            if (key.compareTo(node.key)<0){
                node.left=remove(node.left, key);
                return node;
            }else {
                if (key.compareTo(node.key)>0){
                    node.left=remove(node.right, key);
                    return node;
            }else {
                    if (node.right==null){
                        Node left = node.left;
                        node.left = null;
                        size--;
                        return left;//返回的新的节点
                    }
                    if (node.left==null){
                        Node right= node.right;
                        node.right = null;
                        size--;
                        return right;//返回的新的节点
                    }
                    Node souccer = getMin(node.right);
                    souccer.right=removeMin(node.right);
                    souccer.left = node.left;
                    node.left = node.right = null;
                    return souccer;
                }
            }
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V newValue) throws IllegalAccessException {
        Node node = getNode(root,key);
        if (node==null){
            throw new IllegalAccessException(key + "doesn't exits!");
        }else {
            node.value = newValue;
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
    private Node getNode(Node node,K key){
        if (node==null){
            return null;
        }
        if (key.equals(node.key)){
            return node;
        }else {
            if (key.compareTo(node.key)<0){
                return getNode(node.left, key);
            }else {
                return getNode(node.right, key);
            }
        }
    }
    public void inOder(Node node){
        if (node==null){
            return;
        }System.out.println(node.key+"----"+node.value);
        inOder(node.left);

        inOder(node.right);
    }
}
