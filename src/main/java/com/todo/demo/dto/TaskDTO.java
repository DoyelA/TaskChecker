package com.todo.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.todo.demo.domain.Task;
import com.todo.demo.form.TaskForm;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class TaskDTO extends TaskForm{
    private Long id;
    private String description;
    public TaskDTO(Task task)
    {
    	this.id=task.getId();
    	this.description= task.getDescription();
    }

//    public TaskDTO(Long id, String description, Set<SkillDTO> skillDTOS) {
//    }
//
//    public TaskDTO(Long id, String description) {
//    }
   

}
