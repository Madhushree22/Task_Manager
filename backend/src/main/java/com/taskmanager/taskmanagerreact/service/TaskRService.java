package com.taskmanager.taskmanagerreact.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagerreact.model.TaskR;
import com.taskmanager.taskmanagerreact.repository.TaskRRepository;

@Service
public class TaskRService {
	 @Autowired
	    private TaskRRepository taskRepository;

	    public List<TaskR> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public TaskR getTaskById(Long id) {
	        return taskRepository.findById(id).orElse(null);
	    }

	    public TaskR createTask(TaskR task) {
	        return taskRepository.save(task);
	    }

	    public TaskR updateTask(Long id, TaskR taskDetails) {
	    	TaskR task = taskRepository.findById(id).orElse(null);
	        if (task != null) {
	            task.setTitle(taskDetails.getTitle());
	            task.setDescription(taskDetails.getDescription());
	            task.setPriority(taskDetails.getPriority());
	            task.setDueDate(taskDetails.getDueDate());
	            task.setCompleted(taskDetails.isCompleted());
	            return taskRepository.save(task);
	        }
	        return null;
	    }

	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }
}
