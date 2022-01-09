package com.ziwu.thread.model;

import java.util.concurrent.TimeUnit;

public class A {
    static {
        System.out.println("class A init");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new B();
    }
}
