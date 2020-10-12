package com.rose.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import com.rose.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllByPage(int page, int offset) {
        // 这句是分页的核心
        PageHelper.startPage(page, offset);
        List<User> all = userMapper.findAll();
        return new PageInfo<>(all);
    }

}
