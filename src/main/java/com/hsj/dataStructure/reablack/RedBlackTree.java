package com.hsj.dataStructure.reablack;


/**
 * <p>红黑树（严格遵循左倾的红黑树）<p/>
 * <li>每一个节点或者是红色或者是黑色的<li/>
 * <li>根节点是黑色的<li/>
 * <li>每个叶子节点（最后的空节点）是h黑色的<li/>
 * <li>如果一个节点是红色，那么它的孩子节点都是黑色，如果一个节点是黑色那么它的孩子节点可以是红色也可以是黑色<li/>
 * <li>从任意一个节点到叶子节点，所经过的黑节点是一样的<li/>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/3/23.
 */
public class RedBlackTree<K extends Comparable<K>,V > {
    //红黑树节点的颜色
    //添加的节点初始状态永远是红色，之后再根据具体的情况改变节点的颜色
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        private boolean color;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left = null;
            this.right = null;
            //每次添加的新节点初始状态都为红色
            this.color = RED;
        }
    }
    private Node root;
    private int size;
    public RedBlackTree() {
        //这颗树在没有节点的时候为空，根据红黑树的性质，根节点一定为黑的，空节点也是根节点，所有之后会改变节点的颜色
        root=null;
        size = 0;
    }

    /**
     * <p>返回红黑树节点的个数<p/>
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * <p>判断当前这颗红黑树否为空<p/>
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * <p>判断当前节点的颜色<p/>
     * @param node 当前节点
     * @return
     */
    public boolean isRed(Node node) {
        if (node == null) {
            //空节点的颜色为黑
            return BLACK;
        }
        return node.color;
    }
    /**
     * <p>新插入的元素按照二三树的规则要先融合，融合的元素都是红节点，如果融合的元素比以node为根节点的元素大，那么就要放在node的右边，此时要进行一次左旋转<p/>
     * <p>对节点y进行向左旋转操作，返回旋转后新的根节点x，<p/>
     *       y                             x
     *     /  \                          /   \
     *    T1   x      向左旋转 (y)       y     z
     *        / \   - - - - - - - ->  / \   / \
     *       T2  z                   T1 T2 T3 T4
     *          / \
     *         T3 T4
     * @param y 旋转的节点
     * @return 旋转后返回的新节点
     */
    private Node LeftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        //更新节点的颜色
        //x的节点变成y节点的颜色
        x.color=y.color;
        y.color=RED;
        return x;
    }
    /**
     * <p>新插入的元素按照二三树的规则要先融合，融合的元素都是红节点，如果融合的元素比以node为根节点的三节点的元素小，那么就要放在node的右边，此时要进行一次左旋转<p/>
     * <p>对节点y进行向右旋转操作，返回旋转后新的根节点x，<p/>
     *        y                              x
     *       / \                           /   \
     *     x   T4     向右旋转 (y)        z     y
     *    / \       - - - - - - - ->    / \   / \
     *   z   T3                       T1  T2 T3 T4
     *  / \
     *T1   T2
     * @param y 需要旋转的节点
     * @return 返回旋转后的这个红黑树数新节点
     */
    private Node RightRotate(Node y) {
        Node x=y.left;
        Node T3=x.right;
        x.right=y;
        y.left=T3;
        x.color = y.color;
        y.color = RED;
        return x;

    }

    /**
     * <p>颜色翻转<p/>
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    /**
     * <p>向红黑树中添加节点<p/>
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        //保证根节点永远是黑色的
        root.color = BLACK;
    }

    /**
     * <p>向以node为根节点的红黑树中添加节点<p/>
     * @param node 根节点
     * @param key 键
     * @param value 值
     * @return 返回新的根节点
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            //默认插入的是红节点
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            if (key.compareTo(node.key) > 0) {
                node.right = add(node.right, key, value);
            }else {
                node.value = value;
            }
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = LeftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = RightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

}