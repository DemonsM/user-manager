package com.ink.dao;

import com.ink.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectAll();

    int saveUser(User user);

    int deleteById(@Param("id") Long id);

    User selectOneById(@Param("id") Long id);

    int updateById(@Param("updated") User updated, @Param("id") Long id);

    List<User> selectUserByNameOrPhone(@Param("name") String name, @Param("phone") Long phone);
}
