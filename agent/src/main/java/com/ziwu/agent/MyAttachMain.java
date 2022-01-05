package com.ziwu.agent;

import com.sun.tools.attach.VirtualMachine;

public class MyAttachMain {
    public static void main(String[] args) throws Exception {
        System.out.println("start attach");
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        try {
            vm.loadAgent("D:\\codes\\java\\out\\artifacts\\agent_test_jar\\agent.jar");
        } finally {
            vm.detach();
        }
    }
}
