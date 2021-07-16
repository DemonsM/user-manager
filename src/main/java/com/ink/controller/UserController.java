package com.ink.controller;

import com.ink.entity.User;
import com.ink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
            res.put("message", "用户新增成功");
        } else {
            res.put("success", false);
            res.put("message", "用户新增失败");
        }
        return res;
    }

    @DeleteMapping("/deleteUser")
    public Map<String, Object> deleteUser(@RequestParam("id") Long id) {
        int i = userService.deleteUser(id);
        Map<String, Object> res = new HashMap<>();
        if (i > 0) {
            res.put("success", true);
            res.put("message", "用户删除成功");
        } else {
            res.put("success", false);
            res.put("message", "用户删除失败");
        }
        return res;
    }

    @GetMapping("getUser")
    public User getUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("updateUser")
    public Map<String, Object> updateUser(@RequestParam("id") Long id, @RequestBody User user) {
        int i = userService.updateUser(user, id);
        Map<String, Object> res = new HashMap<>();
        if (i > 0) {
            res.put("success", true);
            res.put("message", "用户更新成功");
        } else {
            res.put("success", false);
            res.put("message", "用户更新失败");
        }
        return res;
    }

    @GetMapping("search")
    public List<User> search(@RequestParam("name") String username, @RequestParam("phone") Long phone) {
        return userService.selectUserByNameOrPhone(username, phone);
    }
}
