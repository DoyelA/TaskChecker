package com.todo.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.demo.constants.messages.ValidationMessages;
import com.todo.demo.validation.annotations.groups.NotBlankGroup;
import com.todo.demo.validation.annotations.groups.NotEmptyGroup;
import com.todo.demo.validation.annotations.groups.NotNullGroup;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskForm {  

	@NotNull(message= ValidationMessages.TASK_DESCRIPTION_NULL, groups= NotNullGroup.class)
    @NotEmpty(message=ValidationMessages.TASK_DESCRIPTION_EMPTY, groups= NotEmptyGroup.class)
    @NotBlank(message=ValidationMessages.TASK_DESCRIPTION_BLANK, groups= NotBlankGroup.class)
    @Length(min=0, max=200, message=ValidationMessages.TASK_DESCRIPTION_LENGTH_EXCEEDED)
    private String description;

//    @NotEmpty(message=ValidationMessages.TASK_SKILLS_EMPTY, groups=NotEmptyGroup.class)
//    private Set<Long> requiredSkillIds;


}
