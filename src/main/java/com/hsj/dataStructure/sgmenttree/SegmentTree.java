package com.hsj.dataStructure.sgmenttree;
/**
 * 使用数组实现线段树
 * Created by 黄仕杰 on 2019/2/28.
 */
@SuppressWarnings("all")
public class SegmentTree<E> {
    private Merger<E> merger;
    private E[] tree;
    private E []data;
    public SegmentTree(E[] arr,Merger merger){
        this.merger = merger;
        //java不允许创建泛型数组，我们使用创建Object类型的数组，然后强转成泛型
        data=(E[]) new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        tree=(E[]) new Object[4*arr.length];
        buildSegmentTree(0, 0, arr.length-1);
    }

    private void buildSegmentTree(int index, int l, int r) {
        if (r==l){
            tree[index] = data[l];
            return;
        }
        int leftIndex = leftChile(index);//左孩子节点
        int rightIndex = rightChile(index);//右孩子节点
        int mid=l+(r-l)/2;//怎样做是为了防止l+r出现溢出的情况
        buildSegmentTree(leftIndex,l,mid);
        buildSegmentTree(rightIndex, mid + 1, r);
        tree[index] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    public E qure(int qleft, int qright) throws IllegalAccessException {
        if (qleft < 0 || qright > data.length - 1 || qleft > qright) {
            throw new IllegalAccessException("Index is illegal");
        }
        return qure(0,0,data.length-1,qleft,qright);
    }
    private E qure(int index,int l,int r,int qlefy, int qright){
        if (l==qlefy&&r==qright){
            return tree[index];
        }
        int leftChile = leftChile(index);
        int rightChile = rightChile(index);
        int mid = l + (r - l) / 2;
        if (qlefy>=mid+1){
            return qure(rightChile, mid + 1, r, qlefy, qright);
        }else {
            if(qright<=mid){
                return qure(leftChile, l, mid, qlefy, qright);
            }
        }
        E leftResult = qure(leftChile, l, mid, qlefy, mid);
        E rightResult = qure(rightChile, mid + 1, r, mid + 1, qright);
        return merger.merge(leftResult, rightResult);
    }
    public int leftChile(int i){
        return i * 2 + 1;
    }
    public int rightChile(int i){
        return i * 2 + 2;
    }
    public int getSize(){
        return data.length;
    }
    public E get(int index) throws IllegalAccessException {
        if (index<0||index>=data.length){
            throw new IllegalAccessException("Index is illegal");
        }
        return data[index];
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i=0;i<tree.length;i++){
            if (tree[i]!=null) {
                str.append(tree[i]);
            }else {
                str.append("null");
            }
            if (i!=tree.length-1){
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }
}
