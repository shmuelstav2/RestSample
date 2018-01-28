package com.example.demo.repo;

import com.example.demo.models.Passwords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository <Passwords, Long>{

    public Passwords findPasswordsByUsername(String username);


    //@Query(val"Select * from my passowrds_new ")
    //public Passwords myQuery(String arg);



   // public List<User> findAll();

}
