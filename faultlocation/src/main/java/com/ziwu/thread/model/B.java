package com.ziwu.thread.model;

public class B {
    static {
        System.out.println("class B init");
        new A();
    }
}
