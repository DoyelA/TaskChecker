package com.todo.demo.service.impl;

import com.todo.demo.service.MessageService;
import com.todo.demo.utils.ResponseUtil;
import com.todo.demo.constants.messages.ExceptionMessage;
import com.todo.demo.constants.messages.ServiceMessage;
import com.todo.demo.domain.Skill;
import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.SkillDTO;
import com.todo.demo.exception.SkillException;
import com.todo.demo.form.SkillForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.todo.demo.repository.SkillRepository;
import com.todo.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SkillServiceImplementation implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private MessageService messageService;
    @Override
    public ResponseDTO<SkillDTO> createSkill(SkillForm skillForm) {    //it will return skill dto
        Skill skill=new Skill();

        skill.setName(skillForm.getName());

        skill=skillRepository.save(skill);
        SkillDTO  skillDTO= new SkillDTO(skill.getId(), skill.getName());
        return new ResponseUtil<SkillDTO>().generateServiceResponse(ServiceMessage.SKILL_CREATED_SUCCESSFULLY, true,skillDTO, HttpStatus.CREATED.value());

        // new ResponseUtil<SkillDTO>().generateServiceResponse(ServiceMessage.SKILL_UPDATED, true, skillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<SkillDTO> updateSkill(Long id, SkillForm skillForm) {
        Skill skill=skillRepository.getOne(id);
        SkillDTO skillDTO=new SkillDTO(id, skillForm.getName());
        boolean updateRequired=false;
        if(!skillForm.getName().equals(skill.getName())){
            skill.setName(skillForm.getName());
            updateRequired=true;
        }
        if(updateRequired){
            skillRepository.save(skill);
        }
        return new ResponseUtil<SkillDTO>().generateServiceResponse(ServiceMessage.SKILL_UPDATED, true, skillDTO, HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<SkillDTO> readSkill(Long id) {
        SkillDTO skillDTO=skillRepository.readSkill(id);
        return new ResponseUtil<SkillDTO>().generateServiceResponse(ServiceMessage.SKILL_FOUND, true, skillDTO,HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<Set<SkillDTO>> readSkills() {
        return new ResponseUtil<Set<SkillDTO>>().generateServiceResponse(ServiceMessage.SKILLS_FOUND, true, skillRepository.readSkills(), HttpStatus.OK.value());
    }

    @Override
    public ResponseDTO<Void> deleteSkill(Long id) {
        skillRepository.deleteById(id);
        return new ResponseUtil<Void>().generateServiceResponse(ServiceMessage.SKILL_DELETED, true, null, HttpStatus.OK.value());
    }
}
