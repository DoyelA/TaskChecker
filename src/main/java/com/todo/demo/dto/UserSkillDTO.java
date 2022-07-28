package com.todo.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.todo.demo.repository.TaskRepository;
import com.todo.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class UserSkillDTO {
private Long user_id;
private String skill_name;
}
