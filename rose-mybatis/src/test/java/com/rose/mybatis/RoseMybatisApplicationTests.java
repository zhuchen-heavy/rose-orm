package com.rose.mybatis;

import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
