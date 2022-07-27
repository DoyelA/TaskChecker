package com.todo.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name="skills",schema = "public")
public class Skill{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "skill_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="skill_seq", schema = "public")
    @Column(name="skill_id", nullable=false, unique=true)
    private Long id;
    
    @Column(name="skill_name", nullable = false, unique = true)
    private String name;

}


//@SecondaryTables({
//        @SecondaryTable(name="EMP_Photo", pkJoinColumns={
//                @PrimaryKeyJoinColumn(name="EMP_Name", referencedColumnName="name"),
//                @PrimaryKeyJoinColumn(name="EMP_ID", referencedColumnName="ID")}),
//        @SecondaryTable(name="EMP_LOB", pkJoinColumns={
//                @PrimaryKeyJoinColumn(name="EMP_Name", referencedColumnName="name"),
//                @PrimaryKeyJoinColumn(name="ID", referencedColumnName="ID")})
//})