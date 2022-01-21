package com.ziwu.jvm.method;

/**
 * 可变长参数重载测试
 */
public class OverloadTest {
    void invoke(Object obj, Object... args) {
        System.out.println("invoke1");
    }

    void invoke(String str, Object obj, Object... args) {
        System.out.println("invoke2");
    }

    public static void main(String[] args) {
        OverloadTest overloadTest = new OverloadTest();
        overloadTest.invoke(null, 1);
        overloadTest.invoke(null, 1, 2);
        overloadTest.invoke(null, new Object[]{1}); //invoke1
    }
}
