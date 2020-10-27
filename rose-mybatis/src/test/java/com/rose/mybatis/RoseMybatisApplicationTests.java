package com.rose.mybatis;

import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoseMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.deleteAll();
        userMapper.insert(new User("zhangsan", "123456"));
        userMapper.insert(new User("zhangsan", "234567"));
        userMapper.insert(new User("zhangsan", "345678"));
        userMapper.insert(new User("xiaoming", "123456"));
        List<User> list = userMapper.findByUsername("zhangsan");
        System.out.println("list : " + list);
    }

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        // org.apache.ibatis.binding.MapperProxy@75a0c890 ：注入的是个代理对象
        System.out.println(userMapper);
    }

    // ------------测试缓存------------

    /**
     * Mybatis的一级缓存：
     * spring boot结合mybatis后，一级缓存状态：
     * 1：在未开启事物的情况之下，每次查询spring都会关闭旧的SqlSession而创建新的SqlSession，因此此时的一级缓存是没有启作用的。
     * 2：在开启事物的情况之下，spring使用threadLocal获取当前资源绑定同一个sqlSession，因此此时一级缓存是有效的。
     */

    // 不启用缓存
    @Test
    public void test3(){
        System.out.println(userMapper.findById(55));
        System.out.println(userMapper.findById(55));
        System.out.println(userMapper.findById(55));
    }

    // 启用缓存：验证1次会话中缓存是否生效
    @Transactional
    @Test
    public void test4(){
        System.out.println(userMapper.findById(55));
        System.out.println(userMapper.findById(55));
        System.out.println(userMapper.findById(55));
    }

    // 启用缓存：增加了对数据库的修改操作，验证在一次数据库会话中，如果对数据库发生了修改操作，一级缓存失效。
    @Transactional
    @Test
    public void test5(){
        System.out.println(userMapper.findById(55));
        userMapper.insert(new User("xiaoming", "789012"));
        System.out.println(userMapper.findById(55));
    }

    // ------------测试插件------------
    @Test
    public void test6(){
        System.out.println(userMapper.findById(55));
    }

    public void test7() throws SQLException, ClassNotFoundException {
        Class.forName("jdbc");
        Connection connection = null;
        try{
            connection= DriverManager.getConnection("db 连接url");
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("sql");
            ps.execute();
            connection.commit();
        } catch (Exception e){
            connection.rollback();
        } finally {
            connection.close();
        }
    }

}
