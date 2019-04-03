# 线性表

## 数组

记录一下用数组实现的线性结构，并实现增删改查。

为了能让自己实现的基于数组的线性结构具有普遍性，我们使用的是泛型程序设计

```java
public class MyString<E> {
    private E[] arry;
    private int size;
```

E[] arry是一个泛型数组，现在还没有初始化，此时相当于c++中的没有指向任何内存的空指针.和数组是一样的，如果只是定义了数组，没有对数组进行初始化，那么我们在使用数组时机会出现空指针异常。我们在构造方法中进行初始化。

```java
/**
     * 构建一个指定容量大小的数组
     * @param capacity 指定的容量大小
     */
    public MyString(int capacity) {
        arry = (E[]) new Object[capacity];
        size = 0;
    }
```

在进行初始化时使用

```java
arry = (E[]) new Object[capacity];
```

而不是

```java
arry =  new E[capacity];
```

应为java不支持直接对泛型数组初始化为泛型数组，所有我们先初始化为Object类型，在进行强制类型转化为E类型

### 接下俩就是CURD

#### 添加操作

```java
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
```

在添加之前先判断数组长度是否大于等于添加的位置,如果大于数组长度则需要对数组进行扩容

```java
if (index == arry.length) {
            resize(2 * arry.length);
        }
```

扩容代码,扩容长度为原始长度的2倍

```java
private void resize(int newCapacity) {
        arry = Arrays.copyOf(arry, newCapacity);

    }
```

判断完数组长度后在进行元素的添加操作，元素添加位置原来的元素和之后的元素都要向后移动一个位置

```java
for (int i=size-1;i>=index;i--) {
            arry[i + 1] = arry[i];
        }
```

#### 删除操作

删除操作和添加操作差不多，这里类比直接给代码

```java
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
```

#### 查询和修改操作

```java
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
```

基于数组实现的线性结构在查询和修改的时间复杂化度都在O(1)级别的，这里实现的线性结构对应java的ArrayList，所以如果对数组的查询和修改的操作比较多的话，使用ArrayList

## 栈和队列

下面使用前面实现的基于数组实现的线性表来实现栈和队列这两种数据结构。

### 栈

栈这种数据结构的特点是先进后出（FILO：Fist In Lsat Out），栈这个字在汉语里古人用栈来来形容干草堆，所以用栈来形容FILO这种数据结构是很形象的。

第一个进入栈内存的元素，最后出去，最后进入的元素第一个退出栈空间。Java方法的执行也是在方法栈中，所以如果死循环的调用会造成栈溢

```java
//在上面数组添加元素的基础上实现在数组头和数组尾元素的添加
public void addFrist(E e){
    add(e,0);
}
public void addLast(E e){
    add(e size);
}
```

栈的实现

```java
/**
     * 入栈操作
     * @param e
     * @throws IllegalAccessException
     */
    @Override
    public void push(E e) throws IllegalAccessException{
        myStrings.addLast(e);


    }

    /**
     * 出栈操作
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E pop() throws IllegalAccessException {
        return myStrings.removeLast();
    }

    /**
     * 返回栈顶的元素，而不是删除它
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E peek() throws IllegalAccessException {
       return myStrings.getValue(getSize() - 1);
    }
```

### 队列

队列这种数据结构特点事先进先出（FIFO：Frist In Frist Out），类似于排队。

队列的实现

```java
/**
     * 向队列添加元素
     *
     * @param e 添加的元素
     * @throws IllegalAccessException
     */
    @Override
    public void add(E e) throws IllegalAccessException {
        myString.addLast(e);
    }
/**
     * <p>从队列中删除元素<p/>
     * @return
     * @throws IllegalAccessException
     */
    public E pop() throws IllegalAccessException {
        return myString.removeFrist();
    }
```

## 链表

### 单链表

链表就是多个节点组成的线性表，每个节点都有连个值，一个是节点本身的值，和当前节点的下一个节点引用