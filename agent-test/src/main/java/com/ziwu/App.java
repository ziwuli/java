package com.ziwu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        while (true) {
            doSum(1, 2);
            Thread.sleep(2000);
        }
    }

    private static int doSum(int i, int i1) {
        return i + i1;
    }
}
