package com.todo.demo.service;

import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskDTO;
import com.todo.demo.dto.TaskSkillDTO;
import com.todo.demo.form.TaskSkillForm;

import java.util.Set;

public interface TaskSkillService {

    ResponseDTO<TaskSkillDTO> createTaskSkill(TaskSkillForm taskSkillForm);

    ResponseDTO<TaskSkillDTO> updateTaskSkill(Long id, TaskSkillForm taskSkillForm);

    ResponseDTO<TaskSkillDTO> getTaskSkill(Long id);

    ResponseDTO<Set<TaskSkillDTO>> getAllTaskSkills();

    ResponseDTO<Void> deleteTaskSkill(Long id);
}
