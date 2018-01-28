package com.example.demo.models;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@SelectBeforeUpdate
@DynamicUpdate
@Table(name="passwordsNew")
public class Passwords {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name="username", unique=true )
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="role")
    private int role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
