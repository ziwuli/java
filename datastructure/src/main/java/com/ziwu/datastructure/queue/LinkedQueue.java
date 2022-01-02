package com.ziwu.datastructure.queue;

import com.ziwu.datastructure.LinkedList;

/**
 * offer and poll options in loop queue algorithm complexity is O(1)
 *
 * @param <E>
 */
public class LinkedQueue<E> {
    private LinkedList<E> stack;

    public LinkedQueue() {
        stack = new LinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public boolean offer(E e) {
        stack.offer(e);
        return true;
    }

    public E poll() {
        return stack.poll();
    }

    public E peekHead() {
        return stack.peek();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
