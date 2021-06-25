package com.ink.service.impl;

import com.ink.dao.UserDao;
import com.ink.entity.User;
import com.ink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.selectAll();
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
