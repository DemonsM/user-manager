package com.ink.service;

import com.ink.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    int saveUser(User user);

    int deleteUser(Long id);

    User getUserById(Long id);

    int updateUser(User user, Long id);

    List<User> selectUserByNameOrPhone(String name, Long phone);
}
