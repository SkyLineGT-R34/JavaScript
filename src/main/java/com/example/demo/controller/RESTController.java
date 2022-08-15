package com.example.demo.controller;

import com.example.demo.model.Roles;
import com.example.demo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RESTController {
    private final UserService userService;
    private final RolesService rolesService;

    @Autowired
    public RESTController(UserService userService, RolesService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @GetMapping("/principal")
    public Users getPerson(@AuthenticationPrincipal Users user) {
        return userService.findUserByEmail(user.getEmail());
    }

    @GetMapping("/new")
    public Users getNew() {
        return new Users();
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.readAll();
    }

    @GetMapping("/roles")
    public List<Roles> getRoles() {
        return rolesService.getAllRoles();
    }

    @PatchMapping("/save")
    public String editUser(@RequestBody Users user) {
        userService.update(user);
        return "User has been saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.delete(id);
        return "User has been deleted";
    }

}
