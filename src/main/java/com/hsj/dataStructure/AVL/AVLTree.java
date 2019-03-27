package com.hsj.dataStructure.AVL;
import java.util.ArrayList;
import java.util.List;

/**
 * AVLS树的实现
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/3/21.
 */
@SuppressWarnings("all")
public class AVLTree<K extends Comparable<K>,V>{
    private class Node{
        private K key;
        private V value;
        //标记每个节点的高度
        private int heigh;
        private Node left;
        private Node right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            left=null;
            right=null;
            heigh=1;
        }
    }
    private Node root;
    private int size;
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(K key, V value) {
        root=add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            //每次创建一个新的节点，她的平衡因子都是1
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            if (key.compareTo(node.key) > 0) {
                node.right = add(node.right, key, value);
            } else {
                //相等的时候更新value
                node.value=value;
            }
        }
        //更新height
        node.heigh = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            //如果得到的平衡因子的值得绝对值大于1那么该二叉树就不是平衡二叉树，需要做一定的变换
            //添加的节点在左边的左边
            if (balanceFactor > 1 && getBalanceFactor(node.left)>=0) {
                //此时需要进行右旋转,为什么这种情况要进行有旋转，我记在笔记里，等会写上笔记的目录
                return RrightRotate(node);
            }
            //添加的节点在右边的右边
            if (balanceFactor < -1 && getBalanceFactor(node.right)<=0) {
                //此时需要进行左旋转,为什么这种情况要进行有旋转，我记在笔记里，等会写上笔记的目录
                return LleftRotate(node);
            }
            //添加的节点在左边的右边
            if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
                //先一次左旋。
                node.left = LleftRotate(node.left);
                //再一次右旋
                return RrightRotate(node);
            }
            //添加的节点在右边的左边
            if (balanceFactor < -1 && getBalanceFactor(node.left) > 0) {
                //先一次右旋
                node.right = RrightRotate(node.right);
                //在一次左旋
                return LleftRotate(node);
            }

        }
        return node;
    }


    public V remove(K key) {
        return null;
    }


    public boolean contains(K key) {
        return false;
    }


    public V get(K key) {
        return null;
    }


    public void set(K key, V newValue) throws IllegalAccessException {

    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }

    /**
     * <p>记录每个节点的高度<p/>
     * @param node 当前节点
     * @return 当前节点的高度值
     */
    private int getHeight(Node node) {
        if(node==null){
            return 0;
        }
        return node.heigh;
    }

    /**
     * <p>获得节点node的平衡因子</p>
     * @param node 目标节点
     * @return 返回的平衡因子
     */
    private int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.left);
    }

    /**
     * <p>判断一棵树是不是二分搜索树，因为二分搜索树的中序遍历是从小到大的输出，所有我们利用这个性质<p/>
     * @return
     */
    private boolean idBST() {
        List<K> list=new ArrayList<>();
        inOrder(root,list);
        for (int i=1;i<list.size();i++) {
            if (list.get(i - 1) .compareTo( list.get(i))>0) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>中序遍历<p/>
     * @param node
     * @param list
     */
    private void inOrder(Node node,List<K> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    /**
     * <p>判断是不是AVL树<p/>
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * <p>递归的遍历节点为node的左右子树高度差是不是为1，符合AVL树任何一个节点的孩子节点的高度差小于等于1的性质<p/>
     * @param node 判断的节点
     * @return 是否为AVL树
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int bnanced = getBalanceFactor(node);
        if (Math.abs(bnanced) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    /**
     * <p>对节点y进行向右旋转操作，返回旋转后新的根节点x，并跟新节点的height<p/>
     *        y                              x
     *       / \                           /   \
     *     x   T4     向右旋转 (y)        z     y
     *    / \       - - - - - - - ->    / \   / \
     *   z   T3                       T1  T2 T3 T4
     *  / \
     *T1   T2
     * @param y 需要旋转的节点
     * @return 返回旋转后的这个AVL数新节点
     */
    private Node RrightRotate(Node y) {
        Node x=y.left;
        Node T3=x.right;
        x.right=y;
        y.left=T3;
        //更新节点的higth
        y.heigh = Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.heigh = Math.max(getHeight(x.right), getHeight(x.left))+1;
        return x;

    }

    /**
     * <p>对节点y进行向左旋转操作，返回旋转后新的根节点x，并跟新节点的height<p/>
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
     private Node LleftRotate(Node y){
         Node x = y.right;
         Node T2=x.left;
         x.left=y;
         y.right=T2;
         y.heigh = Math.max(getHeight(y.left), getHeight(y.right))+1;
         x.heigh = Math.max(getHeight(x.right), getHeight(x.left))+1;
        return x;
     }
}
