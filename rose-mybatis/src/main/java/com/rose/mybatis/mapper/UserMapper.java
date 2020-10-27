package com.rose.mybatis.mapper;

import com.rose.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * dao层
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/10/12
 * @version: v1.0.0
 */
// {@link org.mybatis.spring.annotation.MapperScan}
//@Mapper
public interface UserMapper {

    /**
     * <p>
     * 根据id查询
     * </p>
     *
     * @param id
     * @return
     */
    //@Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    /**
     * <p>
     * 根据username查询
     * 根据注解
     * </p>
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @return
     */
    List<User> findAll();

    /**
     * <p>
     * insert
     * </p>
     *
     * @param user
     * @return 1：成功。0：失败
     */
    int insert(User user);

    /**
     * <p>
     * 清空所有的数据
     * </p>
     */
    void deleteAll();
}
