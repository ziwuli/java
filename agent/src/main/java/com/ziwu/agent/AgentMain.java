package com.ziwu.agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation instrumentation) throws ClassNotFoundException, UnmodifiableClassException {
        System.out.println("agentmain called");
        instrumentation.addTransformer(new MyClassFileTransformer(), true);
        Class<?> classz = Class.forName("com.ziwu.App");
        instrumentation.retransformClasses(classz);
    }
}
