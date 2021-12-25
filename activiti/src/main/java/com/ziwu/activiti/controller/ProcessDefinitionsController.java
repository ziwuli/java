package com.ziwu.activiti.controller;

import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProcessDefinitionsController {
    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    RepositoryService repositoryService;

    @GetMapping("/getDefinitions")
    public List<ProcessDefinition> getProcessDefinitions() {
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 100));
        return processDefinitionPage.getContent();
    }

    @GetMapping("/deployment")
    public String deployProcess() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/sample-process.bpmn20.xml") // 添加bpmn资源
                .addClasspathResource("processes/sample-process.png")  // 添加png资源
                .name("test")
                .deploy();
        return deployment.getId();
    }
}
