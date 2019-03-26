package com.hsj.dataStructure.Tree;
import com.hsj.dataStructure.stock.Stock;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 因为元素要实现使用compareTo比较，所有必须继承Comparable<E>接口
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/1/16.
 * @date 2019/2/18
 */
@SuppressWarnings("all")
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node leftnode, rightnode;

        public Node(E e) {
            this.e = e;
            leftnode = null;
            rightnode = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     *
     * @param e 添加的元素
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }else {
            add(root, e);
        }
    }

    /**
     * 向以node为根节点的二分搜索树中添加元素e
     * 使用递归的方式向二分搜索树中添加元素，宏观语意就是到了下一层递归，判断是应该是向以node.right为根节点添加元素e
     * 还是以nodenode.leftnode为根节点添加元素e
     * 这个过程比较复杂的实现，接下类我们把代码量进行简化
     *
     * @param node 根节点
     * @param e    添加的元素
     */
    private void add(Node node, E e) {
        //递归终止的条件
        if (e.equals(node.e)) {
            return;
        } else {
            if (e.compareTo(node.e) > 0 && node.rightnode == null) {
                node.rightnode = new Node(e);
                size++;
                return;
            } else {
                if (e.compareTo(node.e) < 0 && node.leftnode == null) {
                    node.leftnode = new Node(e);
                    size++;
                    return;
                }

            }
        }
        //递归调用的地方
        if (e.compareTo(node.e) > 0) {
            add(node.rightnode, e);
        } else {
            add(node.leftnode, e);
        }

    }

    /**
     * 简化后的添加操作
     *
     * @param e
     */
    public void add1(E e) {
        root = add1(root, e);
    }

    /**
     * 这个添加的实现是把null也看作是一个节点，当递归到为null是就应该添加一个新的节点，并把这个节点返回给上一层方法，再有上一层方法的左子树或者由右子树来接收
     * 最后返回当前方法的根节点
     *
     * @param node 根节点
     * @param e    添加的元素
     * @return
     */
    private Node add1(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.leftnode = add1(node.leftnode, e);
        } else {
            if (e.compareTo(node.e) > 0) {
                node.rightnode = add1(node.rightnode, e);
            }
        }
        return node;
    }

    /**
     * 查询元素二分搜索树中是否存在元素e.
     * @param e 查询的目标元素
     * @return true存在元素e，false不存在元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     *
     * @param root 查询以root为根的二分搜索树是否存在元素e
     * @param e
     * @return
     */
    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else {
            if (e.compareTo(root.e) < 0) {
                return contains(root.leftnode, e);
            } else {
                return contains(root.rightnode, e);
            }
        }
    }

    /**
     *前序遍历(深度遍历)
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root==null){
            return;
        }
        System.out.println(root.e);
        preOrder(root.leftnode);
        preOrder(root.rightnode);
    }

    /**
     * 借助栈实现非递归的前序遍历(深度遍历)
     * @throws IllegalAccessException
     */
    public void preOrderNR() throws IllegalAccessException {
        Stock<Node> stock = new Stock<>();
        stock.push(root);
        while (!stock.isEmpty()){
            Node node = stock.pop();
            System.out.println(node.e);
            if (node.rightnode!=null){
                stock.push(node.rightnode);
            }
            if (node.leftnode!=null){
                stock.push(node.leftnode);
            }

        }

    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node==null){
            return;
        }
        inOrder(node.leftnode);
        System.out.println(node.e);
        inOrder(node.rightnode);
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node==null){
            return;
        }
        postOrder(node.leftnode);
        postOrder(node.rightnode);
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历,借助队列的存储结构
     */
    public void levelOrder(){
        if (root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.leftnode!=null){
                queue.add(node.leftnode);
            }
            if (node.rightnode!=null){
                queue.add(node.rightnode);
            }
        }
    }

    /**
     * 寻找二分搜索树中最小的元素
     * @return
     */
    public E minmum(){
        return minmum(root).e;
    }

    private Node minmum(Node node) {
        if (node.leftnode==null){
            return node;
        }
        return minmum(node.leftnode);
    }
    /**
     * 寻找二分搜索树中最大的元素
     * @return
     */
    public E maxmum(){
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if (node.rightnode==null){
            return node;
        }
        return maxmum(node.rightnode);
    }

    /**
     * 删除二分搜索树的最小值
     * @return
     */
    public E removeMin(){
        E e = minmum();
        root=removeMin(root);
        return e;
    }

    /**
     * 递归实现删除以node为根节点的二分搜索树的最小值，并返回新的根节点
     * @param node 根节点
     * @return 返回删除后的新的节点
     */
    private Node removeMin(Node node) {
        if (node.leftnode==null){
            Node right = node.rightnode;
            node.rightnode = null;
            size--;
            return right;
        }
        node.leftnode = removeMin(node.leftnode);
        return node;//这个节点返回的是给上一层节点接收的
    }
    /**
     * 删除二分搜索树的最大值
     * @return
     */
    public E removeMax(){
        E e = maxmum();
        root=removeMax(root);
        return e;
    }

    /**
     * 递归实现删除以node为根节点的二分搜索树的最大值，并返回新的根节点
     * @param node 根节点
     * @return 返回删除后的新的节点
     */
    private Node removeMax(Node node) {
        if (node.rightnode==null){
            Node left = node.leftnode;
            node.leftnode = null;
            size--;
            return left;
        }
        node.rightnode = removeMax(node.rightnode);
        return node;
    }

    /**
     * 删除任意位置的节点
     * @param e
     */
    public void remove(E e){
        root=remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node==null){
            return null;
        }
        if (e.equals(node.e)){
            if (node.rightnode==null){
                Node left = node.leftnode;
                node.leftnode=null;
                size--;
                return left;
            }
            if (node.leftnode==null){
                Node right = node.rightnode;
                node.rightnode=null;
                size--;
                return right;
            }
            Node souccer = minmum(node.rightnode);//得到以node.rightnode为根的最的节点
            souccer.rightnode = removeMin(node.rightnode);
            souccer.leftnode = node.leftnode;
            node.rightnode=node.leftnode=null;
            return souccer;//反回的新的节点
        }else {
            if (e.compareTo(node.e)<0){
                node.leftnode = remove(node.leftnode, e);
                return node;
            }else {
                node.rightnode = remove(node.rightnode, e);
                return node;
            }
        }
    }
}
