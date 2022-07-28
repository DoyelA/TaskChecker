package com.todo.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
@Data
@Entity
@Table(name="taskSkills")
@DynamicUpdate
public class TaskSkill {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "task_skill_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="task_skill_seq", schema = "public")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "task_id")
    private Long task_id;

    @Column(name="skill_name")
    private String skill_name;
}
