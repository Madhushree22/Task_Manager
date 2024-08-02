package com.taskmanager.taskmanagerreact.repository;

import com.taskmanager.taskmanagerreact.model.TaskR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRRepository extends JpaRepository<TaskR, Long> {
}
