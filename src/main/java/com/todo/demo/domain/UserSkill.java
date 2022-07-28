package com.todo.demo.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
@Data
@Entity
@Table(name="userSkills")
@DynamicUpdate
public class UserSkill {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_skill_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="user_skill_seq", schema = "public")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name="skill_name")
    private String skill_name;
}
