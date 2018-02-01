package com.example.demo.controllers;


import com.example.demo.models.Passwords;
import com.example.demo.repo.UserRepository;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private UserRepository userRep;

    @GetMapping("/example")
    public String somthing() {
        return "This is the example";
    }


    @PostMapping("/createUser")
    public Passwords createUser(@RequestBody Passwords user){

        if(user!=null){
            userRep.save(user);
            return user;
        }else return null;
    }

   @GetMapping("/users")
    public List <Passwords> findAll () {
       return userRep.findAll();
   }


    @PostMapping("/login")
    public String login (@RequestBody Passwords user){

        JSONObject jo = new JSONObject();
        Passwords retrieved = userRep.findPasswordsByUsername(user.getUsername());
       // Passwords retrieved = userRep.findOne(1L);
        if(retrieved== null){
            // if the user doesnt exist return 5
            jo.put("status", 5);
        }else {
            if(!retrieved.getPassword().equals(user.getPassword())){
                //if the use exist but the passo 4
                jo.put("status", 4);
            }else{
                // and if both are true return the role number
                jo.put("status", retrieved.getRole());
            }
        }
        return jo.toString();
    }





}
