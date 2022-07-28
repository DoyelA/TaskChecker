package com.todo.demo.controller;

import com.todo.demo.constants.url.ApiUrl;
import com.todo.demo.domain.User;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskSkillDTO;
import com.todo.demo.dto.UserSkillDTO;
import com.todo.demo.form.TaskSkillForm;
import com.todo.demo.form.UserSkillForm;
import com.todo.demo.service.TaskSkillService;
import com.todo.demo.service.UserSkillService;
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
@RequestMapping(value=ApiUrl.USER_SKILL_URL)
public class UserSkillController {
    @Autowired
    UserSkillService userSkillService;

    @PostMapping(value="/add")
    public ResponseEntity<ResponseDTO<UserSkillDTO>> addUserSkill(/*@Validated(value= ValidationSequence.class)*/ @RequestBody UserSkillForm userSkillForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            final FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return new ResponseUtil<UserSkillDTO>().generateValidationResponse(fieldError, false, HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseUtil<UserSkillDTO>().generateControllerResponse(userSkillService.createUserSkill(userSkillForm));
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<ResponseDTO<UserSkillDTO>> updateUserSkill(@PathVariable(value="id") Long id, @Validated(value= ValidationSequence.class) @RequestBody UserSkillForm userSkillForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            final FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return new ResponseUtil<UserSkillDTO>().generateValidationResponse(fieldError, false, HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResponseUtil<UserSkillDTO>().generateControllerResponse(userSkillService.updateUserSkill(id, userSkillForm));
    }

    @GetMapping(value="/get/{id}")
    public ResponseEntity<ResponseDTO<UserSkillDTO>> getUserSkillById(@PathVariable(value="id") Long id){
        return new ResponseUtil<UserSkillDTO>().generateControllerResponse(userSkillService.getUserSkill(id));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<Set<UserSkillDTO>>> getAllUserSkills(){
        return new ResponseUtil<Set<UserSkillDTO>>().generateControllerResponse(userSkillService.getAllUserSkills());
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteUserSkill(@PathVariable(value="id") Long id){
        return new ResponseUtil<Void>().generateControllerResponse(userSkillService.deleteUserSkill(id));
    }
}
