package com.todo.demo.dto;

import com.todo.demo.domain.TaskSkill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
@Data
public class TaskSkillDTO {
    public Long task_id;
    public String skill_name;

    public TaskSkillDTO(Long task_id, String skill_name){
        this.task_id=task_id;
        this.skill_name=skill_name;
    }
}
