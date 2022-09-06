package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.User;
import com.sapient.oms.services.IUserService;

@RestController
@RequestMapping("/oms/user")
public class UserController {
    @Autowired //dependency injection
    IUserService userService;//never create object
    @PostMapping("/add-user")
    public Integer createUser(@RequestBody  User user){
        userService.createUser(user);
        return user.getId();
        // System.out.println("Post called "+store.getName());

    }
    @GetMapping("/get-users")
    public String getUsers(){

        List<User> users=userService.getAllUsers();
        return "Users: "+users;
    }

    @GetMapping("/get-users/{id}")
    public User getUserById(@PathVariable("id")Integer id){

        User user=userService.getUserById(id);
        return user;
    }
 
}
