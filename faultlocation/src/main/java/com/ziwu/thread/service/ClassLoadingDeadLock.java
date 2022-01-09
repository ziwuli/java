package com.ziwu.thread.service;

import com.ziwu.thread.model.A;
import com.ziwu.thread.model.B;

public class ClassLoadingDeadLock {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> new A());
        threadA.setName("thread A");
        Thread threadB = new Thread(() -> new B());
        threadB.setName("thread B");
        threadA.start();
        threadB.start();
    }
}
