package com.ziwu.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        while (true) {
            System.out.println("enter");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args));
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
