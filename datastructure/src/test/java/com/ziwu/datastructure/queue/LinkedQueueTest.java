package com.ziwu.datastructure.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {
    @Test
    void size() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        Assertions.assertTrue(linkedQueue.size() == 0);
    }

    @Test
    void isEmpty() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        Assertions.assertTrue(linkedQueue.isEmpty());
    }

    @Test
    void offer() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            linkedQueue.offer(i);
        }
        Assertions.assertTrue(linkedQueue.size() == 20);
    }

    @Test
    void poll() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            linkedQueue.offer(i);
        }
        linkedQueue.poll();
        linkedQueue.poll();
        linkedQueue.poll();
        Assertions.assertTrue(linkedQueue.size() == 17);
        Assertions.assertTrue(linkedQueue.peekHead() == 3);
    }

    @Test
    void pollWhenQueueIsEmpty() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedQueue.poll());
    }

    @Test
    void peekHead() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            linkedQueue.offer(i);
        }
        linkedQueue.peekHead();
        linkedQueue.peekHead();
        Assertions.assertTrue(linkedQueue.peekHead() == 0);
    }
}