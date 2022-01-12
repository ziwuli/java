package com.ziwu.jvm;

/**
 * -XX:+DoEscapeAnalysis 影响测试
 */
public class DoEscapeAnalysisTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("运行时间:" + (end - start));
    }

    private static void alloc() {
        byte[] arr = new byte[1];
        arr[0] = 10;
    }
}
