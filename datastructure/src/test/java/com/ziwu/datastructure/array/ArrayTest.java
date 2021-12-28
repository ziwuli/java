package com.ziwu.datastructure.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayTest {

    @Test
    void add() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        Assertions.assertTrue(array.get(5) == 6);
    }

    @Test
    void remove() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.remove(0);
        array.remove(0);
        Assertions.assertTrue(array.get(3) == 6);
    }

    @Test
    void set() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.remove(0);
        array.set(8, 4);
        Assertions.assertTrue(array.get(4) == 8);
    }

    @Test
    @DisplayName("IndexOutOfBoundsException")
    void getValueWhenIndexOutOfException() {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.remove(0);
        array.set(8, 4);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> array.get(5));
    }
}