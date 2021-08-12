package com;

import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size=0;
    private static final int DEFAULT=16;
    public Stack() {
        elements=(E[]) new Object[DEFAULT];
    }
    public void push(E e){

        elements[size++]=e;
    }
    public E pop(){
        if (size==0)
            throw new EmptyStackException();
        E result=(E)elements[--size];
        elements[size]=null;
        return result;
    }
}
