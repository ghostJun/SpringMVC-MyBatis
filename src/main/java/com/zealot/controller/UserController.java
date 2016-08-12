package com.zealot.controller;

import com.zealot.entity.User;
import com.zealot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GhostJun on 16/8/12.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model) {
        Integer userId = 1;
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "index";
    }
}
