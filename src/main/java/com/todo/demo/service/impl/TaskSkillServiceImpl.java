package com.todo.demo.service.impl;

import com.todo.demo.constants.messages.ExceptionMessage;
import com.todo.demo.constants.messages.ServiceMessage;
import com.todo.demo.domain.TaskSkill;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskSkillDTO;
import com.todo.demo.exception.TaskException;
import com.todo.demo.exception.TaskSkillException;
import com.todo.demo.form.TaskSkillForm;
//import com.todo.demo.repository.SkillRepository;
//import com.todo.demo.repository.TaskRepository;
import com.todo.demo.repository.TaskSkillRepository;
import com.todo.demo.service.TaskSkillService;
import com.todo.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class TaskSkillServiceImpl implements TaskSkillService {
    @Autowired
    private TaskSkillRepository taskSkillRepository;

    @Override
    public ResponseDTO<TaskSkillDTO> createTaskSkill(TaskSkillForm taskSkillForm) {
        try{
        TaskSkill taskSkill = new TaskSkill();
        taskSkill.setTask_id(taskSkillForm.getTask_id());
        taskSkill.setSkill_name(taskSkillForm.getSkill_name());
        taskSkill = taskSkillRepository.save(taskSkill);
        TaskSkillDTO taskSkillDTO = new TaskSkillDTO(taskSkill.getTask_id(), taskSkill.getSkill_name());
        return new ResponseUtil<TaskSkillDTO>().generateServiceResponse(ServiceMessage.TASK_CREATED, true, taskSkillDTO, HttpStatus.CREATED.value());
    }
          catch(Exception e){
        throw new TaskSkillException(ExceptionMessage.TASK_SKILL_ADD_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value(), taskSkillForm);
    }

}

    @Override
    public ResponseDTO<TaskSkillDTO> updateTaskSkill(Long id, TaskSkillForm taskSkillForm) {
        TaskSkill taskSkill=taskSkillRepository.getOne(id);
            taskSkill.setSkill_name(taskSkillForm.getSkill_name());
            taskSkill.setTask_id(taskSkillForm.getTask_id());
        taskSkill=taskSkillRepository.save(taskSkill);
        TaskSkillDTO taskSkillDTO=new TaskSkillDTO(taskSkill.getTask_id(), taskSkill.getSkill_name());
        return new ResponseUtil<TaskSkillDTO>().generateServiceResponse(ServiceMessage.TASK_SKILL_UPDATED,true, taskSkillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<TaskSkillDTO> getTaskSkill(Long id) {
        TaskSkill taskSkill=taskSkillRepository.getOne(id);
        TaskSkillDTO taskSkillDTO= new TaskSkillDTO(taskSkill.getTask_id(), taskSkill.getSkill_name());
        return new ResponseUtil<TaskSkillDTO>().generateServiceResponse(ServiceMessage.TASK_SKILL_FOUND ,true, taskSkillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<Set<TaskSkillDTO>> getAllTaskSkills() {
        try {
            List<TaskSkill> taskSkills = taskSkillRepository.findAll();
            Set<TaskSkillDTO> taskSkillDTOS = new HashSet<>();
            taskSkills.forEach(taskSkill -> {
                taskSkillDTOS.add(new TaskSkillDTO(taskSkill.getTask_id(), taskSkill.getSkill_name()));
            });

            return new ResponseUtil<Set<TaskSkillDTO>>().generateServiceResponse(ServiceMessage.TASK_SKILLS_FETCHED, true, taskSkillDTOS, HttpStatus.OK.value());
        } catch (Exception e) {
            throw new TaskSkillException(ExceptionMessage.TASK_SKILL_GET_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ResponseDTO<Void> deleteTaskSkill(Long id) {
        try{
            taskSkillRepository.deleteById(id);
        }
        catch(Exception e){
            throw new TaskException(ExceptionMessage.TASK_SKILL_DELETE_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseUtil<Void>().generateServiceResponse(ServiceMessage.TASK_SKILL_DELETED, true, null, HttpStatus.OK.value());
    }
    }

