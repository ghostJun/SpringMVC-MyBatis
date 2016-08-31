package com.zealot.service;

import com.zealot.entity.User;
import com.zealot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GhostJun on 16/8/11.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public String getUserNameById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId).getName();
    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findByNameAndPhone(String name, String phone) {
        return userMapper.findByNameAndPhone(name, phone);
    }

    public void add(String name, String phone) {
        String password = "1234";
        String favicon = null;
        userMapper.add(name, phone, password, favicon);
    }
}
