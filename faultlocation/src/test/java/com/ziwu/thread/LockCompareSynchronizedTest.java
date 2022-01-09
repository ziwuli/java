package com.ziwu.thread;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁方式性能测试
 */
public class LockCompareSynchronizedTest {
    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static long cnt = 0;

    @Benchmark
    public void testWithoutLock() {
        doSomething();
    }

    @Benchmark
    public void testReentrantLock() {
        reentrantLock.lock();
        doSomething();
        reentrantLock.unlock();
    }

    @Benchmark
    public void testSynchronized() {
        synchronized (lock) {
            doSomething();
        }
    }

    private void doSomething() {
        cnt += 1;
        if (cnt >= (Long.MAX_VALUE >> 1)) {
            cnt = 0;
        }
    }

    @Test
    public void test() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LockCompareSynchronizedTest.class.getSimpleName())
                .warmupIterations(3) // 预热3次
                .measurementIterations(2).measurementTime(TimeValue.valueOf("1s")) // 运行5次，每次10秒
                .threads(2) // 10线程并发
                .forks(2)
                .build();
        new Runner(opt).run();
    }
}
