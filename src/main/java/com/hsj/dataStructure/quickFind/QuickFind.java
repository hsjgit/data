package com.hsj.dataStructure.quickFind;
/**
 * Created by 黄仕杰 on 2019/3/4.
 */
public class QuickFind implements UF {
    private int[] id;

    public QuickFind(int size) {
        id = new int[size];
        for (int i=0;i<size;i++) {
            //为了让每个数据都不是同一个集合编号
            id[i] = i;
        }
    }

    @Override
    public void unionElement(int p, int q) {
        if (find(p) == find(q)) {
            return;
        }
        for (int i=0;i<id.length;i++) {
            if (id[i] == find(p)) {
                id[i] = find(q);
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * <p>判断p和q是不是在一个集合里<p/>
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnened(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        return id[p];
    }
}
