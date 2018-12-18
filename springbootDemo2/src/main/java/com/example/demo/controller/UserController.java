package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getuser")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("zhang");
        user.setAge(19);
        return user;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer usId){

        return userService.getUserById(usId);

    }

    @RequestMapping(method = RequestMethod.POST)
    public int addUser(@RequestBody User user){

        return userService.addUser(user);

    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public int updateUser(@PathVariable("id") Integer usId,@RequestBody User user){

        user.setId(usId);
        return userService.updateUser(user);

    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("id") Integer usId){

        return userService.deleteUser(usId);

    }

}
