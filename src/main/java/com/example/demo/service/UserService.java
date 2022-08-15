package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

public interface UserService {
    void create(Users user);
    Users read(long  id);
    void update(Users user);
    void delete(long  id);
    List<Users> readAll();
    Users findUserByEmail(String email);
}
