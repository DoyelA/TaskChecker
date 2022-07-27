package com.todo.demo.service.impl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.todo.demo.dto.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.todo.demo.constants.messages.ExceptionMessage;
import com.todo.demo.constants.messages.ServiceMessage;
import com.todo.demo.domain.Task;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.TaskDTO;
import com.todo.demo.exception.TaskException;
import com.todo.demo.form.TaskForm;
import com.todo.demo.repository.SkillRepository;
import com.todo.demo.repository.TaskRepository;
import com.todo.demo.service.TaskService;
import com.todo.demo.utils.ResponseUtil;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public ResponseDTO<TaskDTO> createTask(TaskForm taskForm) {
    	try{
              Task task=new Task();
              task.setDescription(taskForm.getDescription());
              task=taskRepository.save(task);
              TaskDTO taskDTO=new TaskDTO(task);
              return new ResponseUtil<TaskDTO>().generateServiceResponse(ServiceMessage.TASK_CREATED, true, taskDTO, HttpStatus.CREATED.value());
          }
          catch(Exception e){
              throw new TaskException(ExceptionMessage.TASK_ADD_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value(), taskForm);
          }

//              Set<Skill> requiredSkill =new HashSet<>(skillRepository.findAllById(taskForm.getRequiredSkillIds()));
//            Set<SkillDTO> skillDTOS=new HashSet<>(requiredSkill.size());
//            requiredSkill.forEach(skill->{
//             skillDTOS.add(new SkillDTO(skill.getId(), skill.getName()));
//           })
            
            
    }

    @Override
    public ResponseDTO<TaskDTO> updateTask(Long id, TaskForm taskForm) {
        Task task=taskRepository.getOne(id);
        boolean isUpdateRequired=false;
        if(!taskForm.getDescription().equals(task.getDescription())){
            task.setDescription(taskForm.getDescription());
            isUpdateRequired=true;
        }
        task=taskRepository.save(task);
        TaskDTO taskDTO=new TaskDTO(task);
        return new ResponseUtil<TaskDTO>().generateServiceResponse(ServiceMessage.TASK_UPDATED,true, taskDTO, HttpStatus.OK.value());
     }
     //difficult to implement and understand
//        Set<Skill> requiredSkills=new HashSet<>(skillRepository.findAllById(taskForm.getRequiredSkillIds()));
//        Set<Long> skillIds=taskForm.getRequiredSkillIds();
//        Set<Long> setOfSkillIds=requiredSkills.parallelStream().map(Skill::getId).collect(Collectors.toSet());
//        for(Long skillId: taskForm.getRequiredSkillIds()){
//            if(!setOfSkillIds.contains(skillId)){
//                requiredSkills.add(skillRepository.getOne(skillId));
//                isUpdateRequired=true;
//            }
//        }
//        if(isUpdateRequired){
//            try{
//                task.setRequiredSkills(skillIds);
//                task=taskRepository.save(task);
//            }
//            catch(Exception e){
//                throw new TaskException(ExceptionMessage.TASK_UPDATE_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value(), taskForm, new Object[]{id});
//            }
//        }
//        Set<SkillDTO> skillDTOS= new HashSet<>(requiredSkills.size());
//        requiredSkills.forEach(skill->{
//            skillDTOS.add(new SkillDTO(skill.getId(), skill.getName()));
//        });
    
//    if (task.isEmpty()) {
//    	return new ResponseUtil<TaskDTO>().generateServiceResponse(ServiceMessage.INVALID_TASK,true, null, HttpStatus.OK.value());}
//    
    @Override
    public ResponseDTO<TaskDTO> getTask(Long id) {
        Task task=taskRepository.getOne(id);
        TaskDTO taskDTO= new TaskDTO(task);
        return new ResponseUtil<TaskDTO>().generateServiceResponse(ServiceMessage.TASK_FOUND ,true, taskDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<Set<TaskDTO>> getAllTasks() {

        try {
            List<Task> tasks = taskRepository.findAll();
            Set<TaskDTO> taskDTOS = new HashSet<>();
            tasks.forEach(task -> {
                taskDTOS.add(new TaskDTO(task.getId(),task.getDescription()));
            });

            return new ResponseUtil<Set<TaskDTO>>().generateServiceResponse(ServiceMessage.TASKS_FETCHED, true, taskDTOS, HttpStatus.OK.value());
        } catch (Exception e) {
            throw new TaskException(ExceptionMessage.TASK_FETCH_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

    }
    @Override
    public ResponseDTO<Void> deleteTask(Long id) {
        try{
            taskRepository.deleteById(id);
        }
        catch(Exception e){
            throw new TaskException(ExceptionMessage.TASK_DELETE_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseUtil<Void>().generateServiceResponse(ServiceMessage.TASK_DELETED, true, null, HttpStatus.OK.value());
    }
}

