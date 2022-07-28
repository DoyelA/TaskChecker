package com.todo.demo.service;

import com.todo.demo.dto.ResponseDTO;
import com.todo.demo.dto.UserSkillDTO;
import com.todo.demo.form.UserSkillForm;

import java.util.Set;

public interface UserSkillService {
    ResponseDTO<UserSkillDTO> createUserSkill(UserSkillForm userSkillForm);

    ResponseDTO<UserSkillDTO> updateUserSkill(Long id, UserSkillForm userSkillForm);

    ResponseDTO<UserSkillDTO> getUserSkill(Long id);

    ResponseDTO<Set<UserSkillDTO>> getAllUserSkills();

    ResponseDTO<Void> deleteUserSkill(Long id);
}
