package com.ziwu.jvm.tools;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * jit watch  -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation -XX:LogFile=sandbox1.log -XX:+PrintAssembly -XX:-BackgroundCompilation
 */
public class SimpleInliningTest {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello, Java!");
        if (flag == true) System.out.println("Hello, JVM!");
        System.out.println(+0.0F == -0.0F);
        ClassLoader parent = SimpleInliningTest.class.getClassLoader().getParent();
        System.out.println(parent);
    }

    public static class Foo1 {

        private boolean flag;

        public boolean getFlag() {
            return flag;
        }

        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            Unsafe unsafe = getUnsafe();
            Foo1 foo = new Foo1();
            Field field = foo.getClass().getDeclaredField("flag");
            long offset = unsafe.objectFieldOffset(field);
            unsafe.putInt(foo, offset, 2);
            if (foo.getFlag()) System.out.println("Hello,Java");
            if (foo.getFlag() == true) System.out.println("Hello, JVM");

        }

        public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        }
    }
}


