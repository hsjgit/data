package com.hsj.dataStructure.quickFind;

/**
 * <p>QuickUnion的思想是将每一个数看作是一个节点，如果一个节点和另一个节点连载了一起，那么就用一个节点指向另一个节点，此时被指向的节点就变成了根节点，根节点也是一个指针，
 * 节点指向的就是自己。把一个节点并到一个集合，只需要指向这个集合的根节点。这个并查集更像森林。
 * 用数组和下标来实现啊更像是一条链子，下标是自己，而值却是根节点下标p/>
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/3/4.
 */
public class QuickUnion implements UF {
    //根节点
    private int[] parent;
    private int capacity;
    //存储i为根节点的数的节点个数
    private int[] sz;
    public QuickUnion(int capacity){
        parent=new int[capacity];
        sz=new int[capacity];
        //这里的作用是为了让每一个节点的根节点都指向自己
        for (int i=0;i<capacity;i++){
            parent[i]=i;
            sz[i]=1;

        }
    }
    public QuickUnion(){
        this(10);
    }
    @Override
    public void unionElement(int p, int q) {
        //p元素所在集合的根节点
        int proot=find(p);
        //q元素所在集合的根节点
        int qroot=find(q);
        if (find(p)==find(q)){
            return;
        }
        parent[proot]=qroot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnened(int p, int q) {
        return find(p)==find(q);
    }
    private int find(int p){
        if (p<0&&p>parent.length){
            throw new IllegalArgumentException("p is out bount");
        }
        //判断p这个节点的根节点是不是指向自己
        while (p!=parent[p]){
            //如果不是就让那个指向p的节点
            p=parent[p];
        }
        return p;
    }
}
