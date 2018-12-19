package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {


    User getUserById(int userId);

    int addUser(User record);

    int updateUser(User user);

    int deleteUser(int usId);

    List<User> findAll();

}
