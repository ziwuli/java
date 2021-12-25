package com.ziwu.activiti.controller;

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessStartController {
    @Autowired
    private ProcessRuntime processRuntime;

    @RequestMapping("/start-process/{processDefinitionKey}")
    public ProcessInstance startProcess(
            @PathVariable(value = "processDefinitionKey") String processDefinitionKey) {
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey(processDefinitionKey)
                .withVariable("testVariable", "123")
                .build());
        return processInstance;
    }
}
