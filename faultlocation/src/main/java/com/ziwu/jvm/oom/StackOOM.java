package com.ziwu.jvm.oom;

/**
 * -Xms10m -Xmx10m
 */
public class StackOOM {
    public static void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                System.out.println("enter");
                while (true) {
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        stackLeakByThread();
    }
}
