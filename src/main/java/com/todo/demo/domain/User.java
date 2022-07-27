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
@Table(name="User", schema="public")
@DynamicUpdate
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "user_seq", schema = "public")
    @Column(name = "user_id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = true, length = 50)
    private String lastName;
    
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    

}
