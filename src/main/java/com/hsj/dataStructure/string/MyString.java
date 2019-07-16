package com.hsj.dataStructure.string;
import java.util.Arrays;

/**
 * 自己写的一个数组类
 * @author 黄仕杰
 * Created by 黄仕杰 on 2019/2/10.
 * @date 2019/2/10
 */
@SuppressWarnings("all")
public class MyString<E> {
    private E[] arry;
    private int size;

    /**
     * 构建一个指定容量大小的数组
     * @param capacity 指定的容量大小
     */
    public MyString(int capacity) {
        arry = (E[]) new Object[capacity];
        size = 0;
    }

    public MyString() {
        this(20);
    }

    /**
     * 得到数组的元素的个数
     * @return 返回元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 得到数组的容量
     * @return 数组的容量
     */
    public int getCapacity() {
        return arry.length;
    }

    /**
     * 在index位置插入一个新的元素e
     * @param e     添加的元素
     * @param index 插入的位置
     * @throws IllegalAccessException 对应位置不在检索范围异常
     */
    public void add(E e, int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size.");
        }
        if (index == arry.length) {
            resize(2 * arry.length);
        }
        for (int i=size-1;i>=index;i--) {
            arry[i + 1] = arry[i];
        }
        arry[index] = e;
        size++;
    }

    /**
     * 向数组的头添加元素
     * @param e 添加元素
     */
    public void addFrist(E e) throws IllegalAccessException {
        add(e, 0);
    }

    /**
     * 向数组的尾添加元素
     * @param e 添加的元素
     * @throws IllegalAccessException
     */
    public void addLast(E e) throws IllegalAccessException {
        add(e, size);
    }

    /**
     * 得到数组的头元素
     * @return
     */
    public E getFrist() throws IllegalAccessException {
        return getValue(0);
    }

    /**
     * 得到数组的尾元素
     * @return
     */
    public E getLast() throws IllegalAccessException {
        return getValue(size - 1);
    }

    public E getValue(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size.");
        }
        return arry[index];
    }

    /**
     * 删除数组中index处的元素
     * @param index 需要删除位置的元素
     * @return 返回删除的元素
     * @throws IllegalAccessException 对应位置不在检索范围异常
     */
    public E remove(int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size.");
        }
        E ret = arry[index];
        for (int i = index + 1; i < size; i++) {
            arry[i - 1] = arry[i];
        }
        size--;
        if (size == arry.length / 4 && 0 != arry.length / 2) {
            resize(arry.length / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        arry = Arrays.copyOf(arry, newCapacity);

    }

    /**
     * 删除头元素
     * @return 返回被删除的元素
     * @throws IllegalAccessException
     */
    public E removeFrist() throws IllegalAccessException {
        return remove(0);
    }

    /**
     * 删除尾元素
     * @return 返回被删除的元素
     * @throws IllegalAccessException
     */
    public E removeLast() throws IllegalAccessException {
        return remove(size-1);
    }

    /**
     * 把指定位置的元素修改为新的元素
     * @param e 新的元素
     * @param index 修改的位置
     * @return 被修改的元素
     * @throws IllegalAccessException
     */
    public E set(E e,int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add failed. Require index >= 0 and index <= size.");
        }
        arry[index] = e;
        return arry[index];
    }

    /**
     * 判断数组中是否纯在元素e，如果纯在返回true否则返回false
     * @param e 查找的目标元素
     * @return
     */
    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (arry[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    /**
     * 在数组中返回检索目元素，如果纯在返回元素索引，否则返回-1
     * @param e 检索的目标元素
     * @return
     */
    public int fount(E e){
        for (int i=0;i<size;i++){
            if (arry[i].equals(e)){
                return i;
            }
        }

        return -1;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, arry.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(arry[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        MyString<String> m = new MyString<>();
        m.addLast("s");
        m.addLast("g");
        m.removeLast();
        System.out.println(m);
    }

}
