package com.ziwu.datastructure.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

    @Test
    void size() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Assertions.assertTrue(arrayQueue.size() == 0);
    }

    @Test
    void isEmpty() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Assertions.assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void offer() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            arrayQueue.offer(i);
        }
        Assertions.assertTrue(arrayQueue.size() == 20);
    }

    @Test
    void poll() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            arrayQueue.offer(i);
        }
        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.poll();
        Assertions.assertTrue(arrayQueue.size() == 17);
        Assertions.assertTrue(arrayQueue.peekHead() == 3);
    }

    @Test
    void pollWhenQueueIsEmpty() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayQueue.poll());
    }

    @Test
    void peekHead() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            arrayQueue.offer(i);
        }
        arrayQueue.peekHead();
        arrayQueue.peekHead();
        Assertions.assertTrue(arrayQueue.peekHead() == 0);
    }
}