package com.ziwu.jvm.method.exception;

public class ExceptionBytecode1 {
    public int test() {
        int block = 0;
        try {
            block = 1;
            return block;
        } catch (Exception e) {
            block = 2;
        } finally {
            block = 3;
            return block;
        }
    }

    public static void main(String[] args) {
        int test = new ExceptionBytecode1().test();
        System.out.println(test);
    }
}
