package com.zealot.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GhostJun on 16/8/31.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name", "QJ");
        return "/web/index/index";
    }

}
