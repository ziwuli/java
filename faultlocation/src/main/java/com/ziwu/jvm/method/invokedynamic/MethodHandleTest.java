package com.ziwu.jvm.method.invokedynamic;

import java.lang.invoke.MethodHandle;

public class MethodHandleTest {
    public void test(MethodHandle mh, String s) throws Throwable {
        mh.invokeExact(s);
        mh.invokeExact((Object) s);
    }
}
