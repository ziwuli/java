package com.ziwu.activiti.controller;

import org.activiti.api.process.model.ProcessInstanceMeta;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessInstanceController {
    @Autowired
    private ProcessRuntime processRuntime;

    @GetMapping("/process-instance-meta/{processInstanceId}")
    public ProcessInstanceMeta getProcessInstanceMeta(@PathVariable(value = "processInstanceId") String processInstanceId) {
        ProcessInstanceMeta processInstanceMeta = processRuntime.processInstanceMeta(processInstanceId);
        return processInstanceMeta;
    }
}
