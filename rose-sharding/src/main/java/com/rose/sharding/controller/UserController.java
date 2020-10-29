package com.rose.sharding.controller;

import com.rose.sharding.entity.User;
import com.rose.sharding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhu.chen
 * @date: 2020/10/29
 * @version: v1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        userMapper.insert(user);
        return "ok";
    }

    @GetMapping("/select")
    public User select(@RequestParam("username") String username){
        return userMapper.select(username);
    }

}
