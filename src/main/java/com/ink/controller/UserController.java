package com.ink.controller;

import com.ink.entity.User;
import com.ink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
    private final UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public Map<String, Object> saveUser(@RequestBody User user) {
        int i = userService.saveUser(user);
        Map<String, Object> res = new HashMap<>();
        if (i > 0) {
            res.put("success", true);
        } else {
            res.put("success", false);
            res.put("message", "用户新增失败");
        }
        return res;
    }
}
