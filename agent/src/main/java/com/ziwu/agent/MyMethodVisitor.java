package com.ziwu.agent;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class MyMethodVisitor extends MethodVisitor implements Opcodes {
    private String name;

    public MyMethodVisitor(MethodVisitor mv, String name) {
        super(Opcodes.ASM5, mv);
        this.name = name;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(name);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }
}
