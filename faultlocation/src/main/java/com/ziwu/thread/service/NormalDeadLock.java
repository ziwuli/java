package com.ziwu.thread.service;


import lombok.SneakyThrows;

public class NormalDeadLock {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockClass(true));
        Thread t2 = new Thread(new DeadLockClass(false));
        t1.start();
        t2.start();
    }

    static class DeadLockClass implements Runnable {
        boolean flag;

        public DeadLockClass(boolean flag) {
            this.flag = flag;
        }

        @SneakyThrows
        @Override
        public void run() {
            if (flag) {
                synchronized (o1) {
                    System.out.println("A");
                    Thread.sleep(2);
                    synchronized (o2) {
                        System.out.println("waiting1");
                    }
                }
            } else {
                synchronized (o2) {
                    System.out.println("B");
                    synchronized (o1) {
                        System.out.println("waiting2");
                    }
                }
            }
        }
    }
}
