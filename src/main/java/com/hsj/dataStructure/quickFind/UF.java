package com.hsj.dataStructure.quickFind;

/**
 * Created by 黄仕杰 on 2019/3/4.
 */
public interface UF {
    void unionElement(int p,int q);
    int getSize();
    boolean isConnened(int p, int q);
}
