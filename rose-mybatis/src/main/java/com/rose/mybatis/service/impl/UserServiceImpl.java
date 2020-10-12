package com.rose.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import com.rose.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * mapper：该层仅仅实现最原生的crud，所有的分页均在service层做统一的处理
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/10/12
 * @version: v1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllByPage(int page, int offset) {
        // 先分页
        PageHelper.startPage(page, offset);
        List<User> all = userMapper.findAll();
        return new PageInfo<>(all);
    }

}
