package com.itheima.test03;

@FunctionalInterface
public interface MyConsumer<E> {
    void accept(E e);
}
