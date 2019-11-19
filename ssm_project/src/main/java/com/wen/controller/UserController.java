package com.wen.controller;


import com.wen.domain.User;
import com.wen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String showAll(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("list",all);
        System.out.println(all);
        return "list";

    }
    @RequestMapping("/find/{id}")
    public String findById(@PathVariable("id")int id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        System.out.println(user);
        return "success";

    }



}
