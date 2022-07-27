package com.todo.demo.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.demo.constants.messages.ValidationMessages;
import com.todo.demo.validation.annotations.groups.NotBlankGroup;
import com.todo.demo.validation.annotations.groups.NotEmptyGroup;
import com.todo.demo.validation.annotations.groups.NotNullGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskSkillForm {
    @NotNull(message= ValidationMessages.TASK_DESCRIPTION_NULL, groups= NotNullGroup.class)
    @NotEmpty(message=ValidationMessages.TASK_DESCRIPTION_EMPTY, groups= NotEmptyGroup.class)
    @NotBlank(message=ValidationMessages.TASK_DESCRIPTION_BLANK, groups= NotBlankGroup.class)
    private Long task_id;
    @NotNull(message= ValidationMessages.TASK_DESCRIPTION_NULL, groups= NotNullGroup.class)
    @NotEmpty(message=ValidationMessages.TASK_DESCRIPTION_EMPTY, groups= NotEmptyGroup.class)
    @NotBlank(message=ValidationMessages.TASK_DESCRIPTION_BLANK, groups= NotBlankGroup.class)
    private String skill_name;
}
