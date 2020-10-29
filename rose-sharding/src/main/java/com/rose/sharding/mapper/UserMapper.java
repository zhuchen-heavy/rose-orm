package com.rose.sharding.mapper;

import com.rose.sharding.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: zhu.chen
 * @date: 2020/10/29
 * @version: v1.0.0
 */
public interface UserMapper {

    /**
     * <p>
     * 插入数据
     * </p>
     *
     * @param user
     */
    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insert(User user);

    /**
     * <p>
     * 查询
     * </p>
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User select(@Param("username") String username);

}
