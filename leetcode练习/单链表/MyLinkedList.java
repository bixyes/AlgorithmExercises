package com.itheima.test;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyLinkedList<E> {

    private Node<E> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static class  Node<E>{
        E item;
        Node<E> next;

        public Node() {
        }

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = null;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return head==null;
    }

    //在链表头部添加元素
    public void addFirst(E e){
        Node<E> temp = head;
        Node<E> node = new Node<>(e,null);

        node.next = head;
        head = node;
        size++;
    }

    //在链表尾部添加节点
    public void addLast(E e){
        Node<E> temp = head;
        Node<E> node = new Node<>(e,null);

        //如果链表为空，直接将节点设为头节点
        if (isEmpty()){
            head = node;
            size++;
            return;
        }

        while (temp.next!=null){
            temp = temp.next;
        }

        temp.next = node;
        size++;
        return;
    }

    //在指定位置添加节点
    public void add(int index , E e){
        if (index<0 || index>size){
            throw new  IndexOutOfBoundsException("Invalid index:"+index);
        }
        //如果索引为0，相当于在头部添加节点
        if (index == 0){
            addFirst(e);
            return;
        }

        //如果索引==size，相当于在尾部添加节点
        if (index == size){
            addLast(e);
            return;
        }

        //否则，找到索引位置的前一个节点
        Node node = new Node(e,null);
        Node temp = head;

        for (int i = 0; i < index-1; i++) {
            temp = head.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }


    //删除表头节点，并返回数据
    public E removeFirst(){
        //如果链表为空，抛出异常
        if (isEmpty()){
            throw new NoSuchElementException("list is null");
        }

        //获取头节点数据
        E e = head.item;
        //将头节点的next设置为新的头节点
        head = head.next;
        size--;
        return e;
    }

    //删除链表尾部的节点，并返回数据
    public E removeLast(){
        //如果链表为空，抛出异常
        if (isEmpty()){
            throw new NoSuchElementException("list is null");
        }
        //如果链表只有一个节点,相当于删除头节点
        if (head.next==null){
            return removeFirst();
        }

        //否则找到倒数第二的节点
        Node<E> temp = head;
        if (temp.next.next!=null){
            temp = temp.next;
        }
        //获取最后一个节点的数据
        E e = temp.next.item;

        temp.next = null;
        size--;
        return e;
    }

    //删除指定位置的节点，并返回数据
    public E remove(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("Invalid index:"+index);
        }

        //如果索引为0，相当于删除头节点
        if (index==0){
            return removeFirst();
        }

        //如果索引为size-1，相当于删除尾节点
        if (index == size-1){
            return removeLast();
        }

        //否则找到索引前一个节点
        Node<E> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        E e = temp.next.item;
        temp.next=temp.next.next;
        size--;
        return e;
    }

    //获取链表头节点数据
    public E getFirst(){
        //如果链表为空，抛出异常
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        //返回头节点数据
        return head.item;
    }

    //获取链表尾部的数据
    public E getLast(){
        //如果链表为空，抛出异常
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }

        return temp.item;
    }

    //获取指定位置的数据
    public E get(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("Invalid index:"+index);
        }
        //找到索引位置的节点
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.item;
    }




    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        Node<E> temp = head;
        while (temp!=null){
            sj.add(temp.item+"");
            temp = temp.next;
        }
        return sj.toString();
    }


}
