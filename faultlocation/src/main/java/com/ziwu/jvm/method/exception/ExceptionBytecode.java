package com.ziwu.jvm.method.exception;

import java.lang.reflect.Method;

/**
 *  public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=1, locals=5, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: iconst_2
 *          3: istore_1
 *          4: goto          21
 *          7: astore_1
 *          8: iconst_1
 *          9: istore_2
 *         10: iconst_2
 *         11: istore_1
 *         12: goto          21
 *         15: astore_3
 *         16: iconst_2
 *         17: istore        4
 *         19: aload_3
 *         20: athrow
 *         21: iconst_3
 *         22: istore_1
 *         23: return
 *       Exception table:
 *          from    to  target type
 *              0     2     7   Class java/lang/Exception
 *              0     2    15   any
 *              7    10    15   any
 *       jvm编译时将finally快的代码复制到正常出口和异常出口，当没有捕获到catch时会匹配到any异常，这也就是为什么finally快可以永远被执行的原因
 */
public class ExceptionBytecode {
    public static void main(String[] args) {
        try {
            int tryBlock = 0;
        } catch (Exception e) {
            int catchBlock = 1;
        } finally {
            int finallyBlock = 2;
            Method[] declaredMethods = ExceptionBytecode.class.getDeclaredMethods();
        }
        int exit = 3;
    }
}
