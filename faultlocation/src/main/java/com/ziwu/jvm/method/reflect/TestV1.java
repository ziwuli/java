package com.ziwu.jvm.method.reflect;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.lang.reflect.Method;

public class TestV1 {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestV1.class.getSimpleName())
                .warmupIterations(3) // 预热3次
                .measurementIterations(2).measurementTime(TimeValue.valueOf("1s")) // 运行5次，每次10秒
                .threads(2) // 10线程并发
                .forks(2)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testV0() throws Exception {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV1");
        Method target = aClass.getMethod("target", int.class);
        for (int i = 0; i < 200000000; i++) {
            target.invoke(null, 127);
        }

    }

    /**
     * -XX:AutoBoxCacheMax=128  反射时基本类型会被编译成包装类，有装箱开销
     * <p>
     * before
     * TestV1.testV0  thrpt    4  0.764 ± 0.007  ops/s 基准测试
     * TestV1.testV1  thrpt    4  0.154 ± 0.090  ops/s
     * <p>
     * after
     * TestV1.testV0  thrpt    4  7.002 ± 4.660  ops/s
     * TestV1.testV1  thrpt    4  6.378 ± 0.047  ops/s
     *
     * @throws Exception
     */
    //@Benchmark
    public void testV1() throws Exception {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV1");
        Method target = aClass.getMethod("target", int.class);
        for (int i = 0; i < 200000000; i++) {
            target.invoke(null, 128);
        }
    }

    /**
     * 关闭目标方法权限校验
     * before
     * TestV1.testV0  thrpt    4  6.939 ± 5.356  ops/s
     * after
     * TestV1.testV2  thrpt    4  9.368 ± 6.392  ops/s
     */
    //@Benchmark
    public void testV2() throws Exception {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV1");
        Method target = aClass.getMethod("target", int.class);
        target.setAccessible(true);
        for (int i = 0; i < 200000000; i++) {
            target.invoke(null, 128);
        }
    }

    /**
     * 破坏方法内联后性能对比
     * before
     * TestV1.testV0  thrpt    4  6.649 ± 4.910  ops/s
     * after
     * TestV1.testV3  thrpt    4  1.088 ± 0.278  ops/s
     * 对于invokevirtula或者invokeinterface，JVM会记录下调用者的具体类型
     * 缓存调用者的类型宽度  一次性反射类多个方法需要特别留意性能的影响
     * -XX:TypeProfileWidth=3
     * before
     * TestV1.testV0  thrpt    4  6.989 ± 4.859  ops/s
     * after
     * TestV1.testV3  thrpt    4  0.691 ± 0.027  ops/s
     * @throws Exception
     */
    @Benchmark
    public void testV3() throws Exception {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV1");
        Method target = aClass.getMethod("target", int.class);
        target.setAccessible(true);
        polluteProFile();
        for (int i = 0; i < 200000000; i++) {
            target.invoke(null, 128);
        }
    }

    private static void polluteProFile() throws Exception {
        Class<?> aClass = Class.forName("com.ziwu.jvm.method.reflect.TestV1");
        Method target = aClass.getMethod("target1", int.class);
        Method target1 = aClass.getMethod("target2", int.class);
        for (int i = 0; i < 2000; i++) {
            target.invoke(null, 0);
            target1.invoke(null, 0);
        }
    }


    public static void target(int i) {

    }

    public static void target1(int i) {

    }

    public static void target2(int i) {

    }

}
