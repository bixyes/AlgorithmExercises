package com.itheima.demo6;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyLinkedList<E extends Comparable> {

    private Node<E> head;
    private int size;

    public boolean add(E e){
        // 先创建这个结点
        Node<E> node = new Node<>(e, null);
        if(head == null) {
            head = node;
        }else {
           // 头结点是有的，用尾插法。找到尾结点。
           Node<E> temp = head;
           while (temp != null) {
                if(temp.next == null){
                     // temp到了最后一个结点。
                    temp.next = node;
                    break;
                }
                temp = temp.next;
           }
        }
        size++;
        return true;
    }


    public void forEach(){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node<E> temp = head;
        while (temp != null) {
            sj.add(temp.val + "");
            temp = temp.next;
        }
        System.out.println(sj.toString());
    }


    public E deleteAtIndex(int index){
        // 判断索引是否合法
        checkIndexOutOfBounds(index);
        // 删除结点。
        E val = null;
        if(index == 0) {
            // 删除的是头结点。
            val = head.val;
            head = head.next;
        }else {
            // 删除的是后面的结点
            Node<E> node = node(index - 1);
            val = node.next.val;
            node.next = node.next.next;
        }
        size--;
        return val;
    }

    private Node<E> node(int index){
        Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkIndexOutOfBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("delete index out of range 0 -> " + (size - 1) );
        }
    }

    public void sort(){
        // 给头结点对应的链表进行排序。
        Object[] arr = new Object[size];
        int index = 0;
        Node<E> temp = head;
        while (temp != null) {
            arr[index ++] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        // 顺着链表填数据
        Node<E> temp2 = head;
        for (int i = 0; i < arr.length; i++) {
            temp2.val = (E) arr[i];
            temp2 = temp2.next;
        }
    }

    /**
     * 删除结点。
     */

    public void deleteDuplicate(){

        if (head == null) {
            return;
        }
        // 2、定义一个虚拟头节点，用来连接不重复的元素
        Node<E> dummy = new Node<E>(null, head);
        // 3、定义一个变量prev，表示当前不重复元素的前一个节点
        Node<E> prev = dummy;
        // 4、定义一个变量cur，表示当前遍历的节点
        Node<E> cur = head;

        // 5、遍历链表
        while (cur != null) {
            // 6、定义一个变量dup，表示当前节点是否是一个重复元素
            boolean dup = false;
            // 7、使用一个循环来跳过所有和当前节点相同的元素
            while (cur.next != null && cur.val == cur.next.val) {
                // 8、将dup设为true，表示当前节点是一个重复元素
                dup = true;
                // 9、将cur移动到下一个元素
                cur = cur.next;
            }
            // 10、如果dup为false，说明当前节点是一个不重复元素
            if (!dup) {
                // 11、将prev的next设为cur，连接不重复的元素
                prev.next = cur;
                // 12、将prev移动到cur的位置
                prev = cur;
            }
            // 13、否则，说明当前节点是一个重复元素
            else {
                // 14、将prev的next设为null，断开连接
                prev.next = null;
            }
            // 15、将cur移动到下一个元素
            cur = cur.next;
        }
    }




    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(){
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
