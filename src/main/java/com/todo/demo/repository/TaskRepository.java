package com.todo.demo.repository;

import com.todo.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /*@Query(value="select new com.todo.demo.dto.SkillDTO(id) from Skill")
    Set<Long> getRequiredSkillIds();*/
}
