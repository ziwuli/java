package com.ziwu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * heap oom
 * -XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xmx20m
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> data = new ArrayList<>();
        while (true) {
            Thread.sleep(1000);
            data.add(new OOMObject());
        }
    }
}
