package com.ziwu.thread.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    @Test
    public void whenUsingDefaults_thenSingleThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("enter");
                    Thread.sleep(600000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(threadPoolExecutor);
        }
    }
}
