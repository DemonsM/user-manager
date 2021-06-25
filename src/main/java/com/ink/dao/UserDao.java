package com.ink.dao;

import com.ink.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectAll();

    int saveUser(User user);
}
