package com.ziwu.datastructure.stack;

import com.ziwu.datastructure.LinkedList;

import java.util.EmptyStackException;

/**
 * linked Implementation
 *
 * @param <E>
 */
public class LinkedStack<E> {
    private LinkedList<E> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param item the item to be pushed onto this stack.
     * @return the {@code item} argument.
     * @see com.ziwu.datastructure.array.Array#add(Object)
     */
    public E push(E item) {
        stack.push(item);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack (the last item
     * of the {@code LinkedList} object).
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized E pop() {
        E obj;
        int len = stack.size();

        obj = peek();
        stack.remove(len - 1);

        return obj;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack (the last item
     * of the {@code LinkedList} object).
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized E peek() {
        int len = stack.size();
        if (len == 0)
            throw new EmptyStackException();
        return stack.get(len - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
