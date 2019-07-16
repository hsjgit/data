package com.hsj.dataStructure.sgmenttree;

/**
 *
 * @author 黄仕杰
 * @date 2019/2/28
 */
public interface Merger<E> {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    E merge(E a,E b);
}
