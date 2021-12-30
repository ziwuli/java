package com.ziwu.datastructure.stack;

import com.ziwu.datastructure.array.Array;

import java.util.EmptyStackException;

/**
 * Array Implementation
 *
 * @param <E>
 */
public class ArrayStack<E> {
    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
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
        array.add(item);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack (the last item
     * of the {@code Array} object).
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized E pop() {
        E obj;
        int len = array.size();

        obj = peek();
        array.remove(len - 1);

        return obj;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack (the last item
     * of the {@code Array} object).
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized E peek() {
        int len = array.size();
        if (len == 0)
            throw new EmptyStackException();
        return array.get(len - 1);
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }
}
