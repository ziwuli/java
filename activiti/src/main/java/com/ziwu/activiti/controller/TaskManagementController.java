package com.ziwu.activiti.controller;

import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskAdminRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskManagementController {

    @Autowired
    private TaskAdminRuntime taskAdminRuntime;

    @Autowired
    private TaskRuntime taskRuntime;

    @GetMapping("/all-tasks")
    public List<Task> getAllTasks() {
        Page<Task> tasks = taskAdminRuntime.tasks(Pageable.of(0, 100));
        return tasks.getContent();
    }

    @RequestMapping("/complete-task/{taskId}")
    public String completeTask(@PathVariable(value = "taskId") String taskId) {
        taskRuntime.complete(TaskPayloadBuilder.complete()
                .withTaskId(taskId).build());
        return "Completed Task: " + taskId;
    }

    @GetMapping("/my-tasks")
    public List<Task> getMyTasks() {
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 100));
        return tasks.getContent();
    }

}
