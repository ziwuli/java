package com.ziwu.datastructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class LinkedStackTest {

    @Test
    void push() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(11);
        linkedStack.push(22);
        linkedStack.push(33);
        Assertions.assertTrue(3 == linkedStack.size());
    }

    @Test
    void pop() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(11);
        linkedStack.push(22);
        linkedStack.push(33);
        Integer pop = linkedStack.pop();
        Assertions.assertTrue(2 == linkedStack.size());
        Assertions.assertTrue(33 == pop);
        Integer pop1 = linkedStack.pop();
        Assertions.assertTrue(1 == linkedStack.size());
        Assertions.assertTrue(22 == pop1);
    }

    @Test
    void popWhenStackIsEmpty() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(11);
        linkedStack.push(22);
        linkedStack.push(33);
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        Assertions.assertThrows(EmptyStackException.class, () -> linkedStack.pop());
    }

    @Test
    void peek() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(11);
        linkedStack.push(22);
        linkedStack.push(33);
        Integer peek = linkedStack.peek();
        Integer peek1 = linkedStack.peek();
        Assertions.assertTrue(3 == linkedStack.size());
        Assertions.assertTrue(33 == peek);
        Assertions.assertTrue(33 == peek1);
    }

    @Test
    void peekWhenStackIsEmpty() {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        Assertions.assertThrows(EmptyStackException.class, () -> linkedStack.peek());
    }
}