package com.zealot.service;
import com.zealot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
