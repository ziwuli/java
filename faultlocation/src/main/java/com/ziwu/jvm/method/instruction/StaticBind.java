package com.ziwu.jvm.method.instruction;

import org.springframework.util.StopWatch;

/**
 * 内联缓存及退化测试  -XX:CompileCommand=dontinline,*.run
 */
public class StaticBind {
    public static void main(String[] args) {
        Father son1 = new Son1();
        Father son2 = new Son2();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 2000000000; i++) {
            Father sonT = (i < 2000000000) ? son1 : son2;
            sonT.run();
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        for (int i = 0; i < 2000000000; i++) {
            Father sonT = (i % 2 == 0) ? son1 : son2;
            sonT.run();
        }
        stopWatch1.stop();
        System.out.println(stopWatch1.getTotalTimeMillis());
    }
}

class Father {
    public void run() {
    }
}

class Son1 extends Father {
    @Override
    public void run() {
    }
}

class Son2 extends Father {
    @Override
    public void run() {
    }
}