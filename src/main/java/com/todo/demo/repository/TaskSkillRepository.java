package com.todo.demo.repository;

import com.todo.demo.domain.TaskSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSkillRepository extends JpaRepository<TaskSkill, Long> {
}
