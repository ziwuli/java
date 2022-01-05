package com.ziwu.agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation) throws ClassNotFoundException, UnmodifiableClassException {
        System.out.println("test running");
        instrumentation.addTransformer(new MyClassFileTransformer(), true);
        Class<?> classz = Class.forName("com.ziwu.App");
        instrumentation.retransformClasses(classz);
    }
}
