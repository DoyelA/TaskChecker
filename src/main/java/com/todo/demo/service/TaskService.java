package com.todo.demo.service;

import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskDTO;
import com.todo.demo.form.TaskForm;

import java.util.Set;

public interface TaskService {
	
    public ResponseDTO<TaskDTO> createTask(TaskForm taskForm);
    public ResponseDTO<TaskDTO> updateTask(Long id, TaskForm taskForm);
    public ResponseDTO<TaskDTO> getTask(Long id);
    public ResponseDTO<Set<TaskDTO>> getAllTasks();
    public ResponseDTO<Void> deleteTask(Long id);
}
