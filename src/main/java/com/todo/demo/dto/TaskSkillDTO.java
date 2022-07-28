package com.todo.demo.dto;

import com.todo.demo.domain.TaskSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskSkillDTO {
    public Long task_id;
    public String skill_name;

}
