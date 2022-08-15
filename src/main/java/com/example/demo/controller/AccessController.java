package com.example.demo.controller;

import com.example.demo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.security.Principal;

@Controller
public class AccessController {
    private final UserService userService;
    private final RolesService rolesService;

    @Autowired
    public AccessController(UserService userService, RolesService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @GetMapping({"/user","/"})
    public String userEnter(Model model, Principal principal) {
        model.addAttribute("principal", userService.findUserByEmail(principal.getName()));
        return "index";
    }
    @GetMapping({"/index","/"})
    public String adminEnter(Model model, Principal principal) {
        model.addAttribute("principal", userService.findUserByEmail(principal.getName()));
        return "index";
    }
}

