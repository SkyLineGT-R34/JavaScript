package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.demo.model.Roles;
import com.example.demo.model.Users;
import com.example.demo.service.RolesService;
import com.example.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBInit {
    private final UserService userService;
    private final RolesService rolesService;

    @Autowired
    public DBInit(UserService userService, RolesService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @PostConstruct
    private void postConstruct() {
        rolesService.save(new Roles("ROLE_ADMIN"));
        rolesService.save(new Roles("ROLE_USER"));
        List<Roles> rolesA = rolesService.getAllRoles();
        userService.create(new Users("admin", "admin", "admin@mail.ru", "admin", 1999, rolesA));
        List<Roles> rolesU = rolesService.getAllRoles().subList(1,2);
        userService.create(new Users("user", "user", "user@mail.ru", "user", 2000, rolesU));
    }
}