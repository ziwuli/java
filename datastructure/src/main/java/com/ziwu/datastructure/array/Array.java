package com.ziwu.datastructure.array;

import jdk.internal.util.ArraysSupport;

import java.util.Arrays;
import java.util.Objects;


public class Array<E> {

    private final static int DEFAULT_CAPACITY = 5;

    protected int size = 0;

    protected E[] elementData;

    public Array() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E t) {
        if (elementData.length == size) {
            grow();
        }
        elementData[size] = t;
        size++;
    }

    private void grow() {
        //缩容大小为元容量的1.5倍，如果需要考虑缩容场景则将因子变为0.25的容量减小复杂度震荡带来的影响
        int oldCapacity = elementData.length;
        int newCapacity = ArraysSupport.newLength(oldCapacity, DEFAULT_CAPACITY, oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        // 将index+1之后的元素向左移动
        for (int i = index + 1; i < elementData.length; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
    }

    public boolean set(E o, int index) {
        Objects.checkIndex(index, size);
        elementData[index] = o;
        return false;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

}
