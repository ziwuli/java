package com.ziwu.jvm.method.invokedynamic;

import java.lang.invoke.*;

public class Circuit {
    public static void main(String[] args) {
        startRace(new Deer());
    }

    private static void startRace(Object obj) {

    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType callSiteType) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle mh = lookup.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callSiteType));
    }
}
