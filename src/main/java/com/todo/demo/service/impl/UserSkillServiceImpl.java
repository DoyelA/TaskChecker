package com.todo.demo.service.impl;

import com.todo.demo.constants.messages.ExceptionMessage;
import com.todo.demo.constants.messages.ServiceMessage;
import com.todo.demo.domain.UserSkill;
import com.todo.demo.domain.User;
import com.todo.demo.domain.UserSkill;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskSkillDTO;
import com.todo.demo.dto.UserSkillDTO;
import com.todo.demo.exception.TaskException;
import com.todo.demo.exception.TaskSkillException;
import com.todo.demo.form.UserSkillForm;
import com.todo.demo.repository.UserSkillRepository;
import com.todo.demo.service.UserSkillService;
import com.todo.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserSkillServiceImpl implements UserSkillService {
    @Autowired
    private UserSkillRepository userSkillRepository;

    @Override
    public ResponseDTO<UserSkillDTO> createUserSkill(UserSkillForm userSkillForm) {
        try{
            UserSkill userSkill = new UserSkill();
            userSkill.setUser_id(userSkillForm.getUser_id());
            userSkill.setSkill_name(userSkillForm.getSkill_name());
            userSkill = userSkillRepository.save(userSkill);
            UserSkillDTO userSkillDTO = new UserSkillDTO(userSkill.getUser_id(), userSkill.getSkill_name());
            return new ResponseUtil<UserSkillDTO>().generateServiceResponse(ServiceMessage.TASK_CREATED, true, userSkillDTO, HttpStatus.CREATED.value());
        }
        catch(Exception e){
            throw new TaskSkillException(ExceptionMessage.TASK_SKILL_ADD_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseDTO<UserSkillDTO> updateUserSkill(Long id, UserSkillForm userSkillForm) {
        UserSkill userSkill=userSkillRepository.getOne(id);
        userSkill.setSkill_name(userSkillForm.getSkill_name());
        userSkill.setUser_id(userSkillForm.getUser_id());
        userSkill=userSkillRepository.save(userSkill);
        UserSkillDTO userSkillDTO=new UserSkillDTO(userSkill.getUser_id(), userSkill.getSkill_name());
        return new ResponseUtil<UserSkillDTO>().generateServiceResponse(ServiceMessage.TASK_SKILL_UPDATED,true, userSkillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<UserSkillDTO> getUserSkill(Long id) {
        UserSkill userSkill=userSkillRepository.getOne(id);
        UserSkillDTO userSkillDTO= new UserSkillDTO(userSkill.getUser_id(), userSkill.getSkill_name());
        return new ResponseUtil<UserSkillDTO>().generateServiceResponse(ServiceMessage.TASK_SKILL_FOUND ,true, userSkillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<Set<UserSkillDTO>> getAllUserSkills() {
        try {
            List<UserSkill> userSkills = userSkillRepository.findAll();
            Set<UserSkillDTO> userSkillDTOS = new HashSet<>();
            userSkills.forEach(userSkill -> {
                userSkillDTOS.add(new UserSkillDTO(userSkill.getUser_id(), userSkill.getSkill_name()));
            });

            return new ResponseUtil<Set<UserSkillDTO>>().generateServiceResponse(ServiceMessage.TASK_SKILLS_FETCHED, true, userSkillDTOS, HttpStatus.OK.value());
        } catch (Exception e) {
            throw new TaskSkillException(ExceptionMessage.TASK_SKILL_GET_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseDTO<Void> deleteUserSkill(Long id) {
        try{
            userSkillRepository.deleteById(id);
        }
        catch(Exception e){
            throw new TaskException(ExceptionMessage.TASK_SKILL_DELETE_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseUtil<Void>().generateServiceResponse(ServiceMessage.TASK_SKILL_DELETED, true, null, HttpStatus.OK.value());
    }
}