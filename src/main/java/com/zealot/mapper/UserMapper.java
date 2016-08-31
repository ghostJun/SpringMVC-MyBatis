package com.zealot.mapper;

import com.zealot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<User> findAll();

    User selectByPrimaryKey(Integer id);

    User findByNameAndPhone(String name, String phone);

    void add(String name, String password, String phone, String favicon);

}