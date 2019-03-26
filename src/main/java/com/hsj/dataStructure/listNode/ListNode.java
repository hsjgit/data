package com.hsj.dataStructure.listNode;


/**
 * 模拟实现的单链表的增删改查
 * Created by 黄仕杰 on 2019/1/23.
 * @author 黄仕杰
 * @date 2019/1/24
 */

public class ListNode<E>{
    private class Node{
        private E e;
        private Node next;
        public Node(E e,Node node){
            this.e=e;
            this.next=node;
        }
        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private int size;
    private Node dummyHead;
    public  ListNode(){
        dummyHead=new Node(null,null);
        size=0;
    }

    /**
     * 返回链表的长度
     * @return
     */
    public int getlength(){
        return size;
    }
    public boolean isEmplty(){
        return size==0;
    }

    /**
     * 添加对象
     * 利用虚拟头节点的方法
     * prev所指的就是需要添加节点的抢一个节点，所以循环到index节点而不是index-1节点
     * @param e
     */
    public void add(E e,int index){
        Node prev= dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        /*Node node = new Node(e, prev.next);
        prev.next = node;*/
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 向链表头添加节点
     * @param e
     */
    public void addFrist(E e){
        add(e,0);
    }

    /**
     * 向链表为添加节点
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }

    /**
     * 删除节点
     * @param index
     */
    public E remove(int index){
        Node prev=dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        Node renode=prev.next;
        prev.next=renode.next;
        renode.next=null;
        size--;
        return renode.e;
    }

    /**
     *删除链表的尾元素
     */
    public void removeLast(){
        remove(size);
    }

    /**
     * 删除头元素
     */
    public void removeFrist(){
        remove(0);
    }

    /**
     * 删除节点值为e的节点
     * @param e
     */
    public void removeElement(E e){
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next!=null){
            Node delnode=prev.next;
            prev.next=delnode.next;
            delnode.next = null;
        }
    }
    public boolean contains(E e){
        Node cre = dummyHead.next;
        while (cre!=null){
            if (e.equals(cre.e)){
                return true;
            }
            cre = cre.next;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder sre = new StringBuilder();
        Node cre = dummyHead.next;
        while (cre!=null){
            sre.append(cre.e+"->");
            cre = cre.next;
        }
        sre.append("NULL");
        return sre.toString();
    }

    public static void main(String[] args) {
        ListNode<String> listNode = new ListNode<>();
        listNode.addFrist("dsad1");
        listNode.addFrist("dsad");
        listNode.addFrist("dsad");
        listNode.addFrist("dsad2");
        listNode.addLast("huangshijie");
        System.out.println(listNode);
        listNode.removeFrist();
        System.out.println(listNode);
        System.out.println(listNode.contains("dsad"));

    }

}
