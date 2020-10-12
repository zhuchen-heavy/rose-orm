package com.rose.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.rose.mybatis.entity.User;

public interface UserService {

    /**
     * <p>
     * 分页查询
     * </p>
     *
     * @param page
     * @param offset
     * @return
     */
    PageInfo<User> findAllByPage(int page, int offset);

}
