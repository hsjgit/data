package com.hsj.dataStructure.Queues;
import com.hsj.dataStructure.heap.Minheap;

/**
 * 优先队列的实现，java自身的优先队列也叫 PriorityQueues
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/27.
 * @date 2019/2/27
 */
@SuppressWarnings("all")
public class PriorityQueues<E extends Comparable<E>> implements IQueues<E> {
    private Minheap<E> heap;

    /**
     * 构造初始容量大小为 capacity 的优先队列
     * @param capacity
     */
    public PriorityQueues(int capacity){
        heap = new Minheap<>(capacity);
    }
    @Override
    public void add(E e) throws IllegalAccessException {
        heap.add(e);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public E element() throws IllegalAccessException {
        return null;
    }
    public E remove(){
        return heap.extractMin();
    }
}
