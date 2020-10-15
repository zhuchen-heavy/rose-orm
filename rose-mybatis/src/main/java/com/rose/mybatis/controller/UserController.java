package com.rose.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import com.rose.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8082/mybatis/find?page=1&offset=10 ： 从第一页开始，每页10条
     *
     * @param page   开始的页
     * @param offset 偏移量：即每页查询多少条
     * @return
     */
    @GetMapping("find")
    public PageInfo<User> findAllByPage(@RequestParam("page") int page, @RequestParam("offset") int offset) {
        return userService.findAllByPage(page, offset);
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("insert")
    public String insert() {
        userMapper.insert(new User("zhangsan", "123456"));
        return "ok";
    }

}
