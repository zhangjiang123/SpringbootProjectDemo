package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int addUser(User record) {
        return userDao.insert(record);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(int usId) {
        return userDao.deleteByPrimaryKey(usId);
    }

}
