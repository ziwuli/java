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

    @Test
    void get() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        Assertions.assertEquals(testVal.get(0), 0);
        Assertions.assertEquals(testVal.get(1), 1);
        Assertions.assertEquals(testVal.get(4), 4);
    }

    @Test
    void set() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        testVal.set(1, 8);
        testVal.set(1, 7);
        testVal.set(4, 6);
        Assertions.assertEquals("[0,7,2,3,6]", String.valueOf(testVal.toString()));
    }

    @Test
    void testAdd() {
        LinkedList<Integer> testVal = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        testVal.add(1, -1);
        Assertions.assertEquals("[0,-1,1,2,3,4]", String.valueOf(testVal.toString()));
        testVal.add(0, -2);
        Assertions.assertEquals("[-2,0,-1,1,2,3,4]", String.valueOf(testVal.toString()));
        System.out.println();
        testVal.add(7, 5);
        Assertions.assertEquals("[-2,0,-1,1,2,3,4,5]", String.valueOf(testVal.toString()));
    }

    @Test
    void testAdd1() {
        java.util.LinkedList<Integer> testVal = new java.util.LinkedList<>();
        for (int i = 0; i < 5; i++) {
            testVal.add(i);
        }
        testVal.add(5, -1);
        Assertions.assertEquals("[0,1,2,3,4,-1]", String.valueOf(testVal.toString()));
    }
}