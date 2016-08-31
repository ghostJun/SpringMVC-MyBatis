package com.zealot.controller.manage;

import com.zealot.entity.User;
import com.zealot.mapper.UserMapper;
import com.zealot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by GhostJun on 16/8/12.
 */

@Controller
@RequestMapping("manage/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public String list(Model model) {
//        List<User> list = userService.findAll();
        List<User> list = userMapper.findAll();
        model.addAttribute("list", list);
        return "user/list";
    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }


    @RequestMapping("/save")
    public void save(String name, String phone) {
//        User user = userService.findByNameAndPhone(name, phone);
//        if (user != null) {
//            return;
//        } else {
        userService.add(name, phone);
//        }
    }
}
