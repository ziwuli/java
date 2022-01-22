package com.ziwu.jvm.method.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * -verbose:class
 */
public class TestV0 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV0");
        Method target = aClass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            target.invoke(null, i);
        }
    }

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }
}
