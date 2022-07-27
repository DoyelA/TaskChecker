package com.todo.demo.controller;

import com.todo.demo.constants.url.ApiUrl;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskDTO;
import com.todo.demo.dto.TaskSkillDTO;
import com.todo.demo.form.TaskForm;
import com.todo.demo.form.TaskSkillForm;
import com.todo.demo.service.TaskSkillService;
import com.todo.demo.utils.ResponseUtil;
import com.todo.demo.validation.annotations.sequence.ValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value="/taskill")
public class TaskSkillController {
    @Autowired
    TaskSkillService taskSkillService;

    @PostMapping(value="/add")
    public ResponseEntity<ResponseDTO<TaskSkillDTO>> addTaskSkill(/*@Validated(value= ValidationSequence.class)*/ @RequestBody TaskSkillForm taskSkillForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            final FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return new ResponseUtil<TaskSkillDTO>().generateValidationResponse(fieldError, false, HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseUtil<TaskSkillDTO>().generateControllerResponse(taskSkillService.createTaskSkill(taskSkillForm));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ResponseDTO<TaskSkillDTO>> updateTaskSkill(@PathVariable(value="id") Long id, @Validated(value=ValidationSequence.class) @RequestBody TaskSkillForm taskSkillForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            final FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return new ResponseUtil<TaskSkillDTO>().generateValidationResponse(fieldError, false, HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseUtil<TaskSkillDTO>().generateControllerResponse(taskSkillService.updateTaskSkill(id, taskSkillForm));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ResponseDTO<TaskSkillDTO>> getTaskSkillById(@PathVariable(value="id") Long id){
        return new ResponseUtil<TaskSkillDTO>().generateControllerResponse(taskSkillService.getTaskSkill(id));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<Set<TaskSkillDTO>>> getAllTaskSkills(){
        return new ResponseUtil<Set<TaskSkillDTO>>().generateControllerResponse(taskSkillService.getAllTaskSkills());
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteTaskSkill(@PathVariable(value="id") Long id){
        return new ResponseUtil<Void>().generateControllerResponse(taskSkillService.deleteTaskSkill(id));
    }


}
