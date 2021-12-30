package com.ziwu.datastructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class ArrayStackTest {

    @Test
    void push() {
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        integerArrayStack.push(11);
        integerArrayStack.push(22);
        integerArrayStack.push(33);
        Assertions.assertTrue(3 == integerArrayStack.size());
    }

    @Test
    void pop() {
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        integerArrayStack.push(11);
        integerArrayStack.push(22);
        integerArrayStack.push(33);
        Integer pop = integerArrayStack.pop();
        Assertions.assertTrue(2 == integerArrayStack.size());
        Assertions.assertTrue(33 == pop);
        Integer pop1 = integerArrayStack.pop();
        Assertions.assertTrue(1 == integerArrayStack.size());
        Assertions.assertTrue(22 == pop1);
    }

    @Test
    void popWhenStackIsEmpty() {
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        integerArrayStack.push(11);
        integerArrayStack.push(22);
        integerArrayStack.push(33);
        integerArrayStack.pop();
        integerArrayStack.pop();
        integerArrayStack.pop();
        Assertions.assertThrows(EmptyStackException.class, () -> integerArrayStack.pop());
    }

    @Test
    void peek() {
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        integerArrayStack.push(11);
        integerArrayStack.push(22);
        integerArrayStack.push(33);
        Integer peek = integerArrayStack.peek();
        Integer peek1 = integerArrayStack.peek();
        Assertions.assertTrue(3 == integerArrayStack.size());
        Assertions.assertTrue(33 == peek);
        Assertions.assertTrue(33 == peek1);
    }

    @Test
    void peekWhenStackIsEmpty() {
        ArrayStack<Integer> integerArrayStack = new ArrayStack<>();
        Assertions.assertThrows(EmptyStackException.class, () -> integerArrayStack.peek());
    }
}