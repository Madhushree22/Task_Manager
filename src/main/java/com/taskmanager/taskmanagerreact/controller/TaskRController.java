package com.taskmanager.taskmanagerreact.controller;
import com.taskmanager.taskmanagerreact.model.TaskR;
import com.taskmanager.taskmanagerreact.service.TaskRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskRController {
	 @Autowired
	    private TaskRService taskService;

	    @GetMapping
	    public List<TaskR> getAllTasks() {
	        return taskService.getAllTasks();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TaskR> getTaskById(@PathVariable Long id) {
	    	TaskR task = taskService.getTaskById(id);
	        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
	    }

	    @PostMapping
	    public TaskR createTask(@RequestBody TaskR task) {
	        return taskService.createTask(task);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TaskR> updateTask(@PathVariable Long id, @RequestBody TaskR taskDetails) {
	    	TaskR updatedTask = taskService.updateTask(id, taskDetails);
	        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	        return ResponseEntity.noContent().build();
	    }
}
