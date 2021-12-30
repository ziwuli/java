package com.ziwu.datastructure.queue;

import java.util.Arrays;

/**
 * offer and poll options in loop queue algorithm complexity is O(1)
 *
 * @param <E>
 */
public class ArrayQueue<E> {
    private E[] elementData;

    private int size;

    private int head = 0;

    private int tail = 0;

    private final static int DEFAULT_CAPACITY = 5;

    public ArrayQueue() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(E e) {
        int newTail = (tail + 1) % elementData.length;
        if (newTail == head) {
            int index = elementData.length - 1;
            grow();
            for (int i = 0; i < head; i++) {
                elementData[index++] = elementData[i];
            }
            elementData[index++] = e;
            tail = index;
        } else {
            elementData[tail] = e;
            tail = newTail;
        }
        size++;
        return true;
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    public E poll() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
        E o = elementData[head];
        head++;
        size--;
        return o;
    }

    public E peekHead() {
        return elementData[head];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = head; i < tail; i++) {
            stringBuilder.append(elementData[i]).append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
