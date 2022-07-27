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
@Table(name="userSkills")
@DynamicUpdate
public class UserSkill {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="task_seq", schema = "public")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @ManyToOne(cascade = {javax.persistence.CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = {javax.persistence.CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    private Skill skill;



    
}
