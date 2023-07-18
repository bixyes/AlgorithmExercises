package com.itheima.test03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;



public class MyArrayList<T> {
    // 数组变量
    private T[] elementData;
    // 元素个数
    private int size;

    // 默认构造方法
    public MyArrayList() {
        // 初始化数组为默认大小
        this(10);
    }

    // 带初始容量参数的构造方法
    public MyArrayList(int initialCapacity) {
        // 初始化数组为指定大小
        elementData = (T[]) new Object[initialCapacity];
        // 初始化元素个数为0
        size = 0;
    }

    private void ensureCapacity(int minCapacity){
        //如果最小容量大于数组长度
        if (minCapacity>elementData.length){
            //创建一个新数组，大小为原来的两倍
            T[] newArray = (T[]) new Object[elementData.length*2];
            //将数组原来的元素复制到新的数组
            System.arraycopy(elementData,0,newArray,0,size);
            //将新数组赋值给elementData
            elementData = newArray;
        }
    }

    //在集合末尾添加一个元素
    public void add(T e){
        //确保有足够的空间存储元素
        ensureCapacity(size+1);
        elementData[size]=e;
        size++;
    }

    //根据索引获取集合中的元素
    public T get(int index){
        if (index<0 || index>=size){
            // 抛出异常
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        //返回数组中的元素
        return elementData[index];
    }

    //根据索引删除元素,并返回被删除的元素
    public T remove(int index){
        if (index<0 || index>=size){
            // 抛出异常
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T e = elementData[index];
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        size--;
        return e;
    }

    //返回集合中元素的个数
    public int size(){
        return size;
    }



    public void forEach(MyConsumer<T> action) {
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept((T) elementData[i]);
        }
    }

    @Override
    public String toString() {
        T[] arr = (T[]) new Object[size];
        System.arraycopy(elementData,0,arr,0,size);
        return Arrays.toString(arr);
    }
}
