package com.ziwu.jvm.oom;

/**
 * -Xss180k
 */
public class StackSOF {
    private static int stackDeep = 1;

    public static void stackLeak() {
        stackDeep++;
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } finally {
            System.out.println(stackDeep);
        }
    }
}
