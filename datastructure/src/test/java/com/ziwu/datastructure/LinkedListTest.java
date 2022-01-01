package com.ziwu.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        Assertions.assertTrue(testVal.size == 5);
        Assertions.assertEquals("[0,1,2,3,4]", String.valueOf(testVal.toString()));
    }

    @Test
    void remove() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        testVal.remove(Integer.valueOf(3));
        Assertions.assertTrue(testVal.size == 4);
        Assertions.assertEquals("[0,1,2,4]", String.valueOf(testVal.toString()));
    }

    @Test
    void testRemoveByIndex() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        testVal.remove(3);
        Assertions.assertEquals("[0,1,2,4]", String.valueOf(testVal.toString()));
        testVal.remove(0);
        Assertions.assertEquals("[1,2,4]", String.valueOf(testVal.toString()));
        testVal.remove(2);
        Assertions.assertEquals("[1,2]", String.valueOf(testVal.toString()));
    }
}