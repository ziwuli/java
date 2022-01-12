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

    public static void main(String[] args) {
        List<OOMObject> data = new ArrayList<>();
        while (true) {
            data.add(new OOMObject());
        }
    }
}
