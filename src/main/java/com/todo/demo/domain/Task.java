package com.todo.demo.domain;

import java.io.Serializable;

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
@Table(name="Tasks", schema="public")
@Entity
@DynamicUpdate
public class Task implements Serializable {
	private static final long serialVersionUID = 3425289481696672738L;

	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(allocationSize = 1,initialValue = 1,name="task_seq", schema = "public")
    @Column(name="task_id", nullable=false, unique=true)
    private Long id;

    @Column(name="task_description", nullable = false, length=200)
    private String description;
    
//    @Column(name="name", nullable = false, length=200)
//    private String name;
//

}
