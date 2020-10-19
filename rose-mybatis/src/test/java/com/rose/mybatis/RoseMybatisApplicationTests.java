package com.rose.mybatis;

import com.rose.mybatis.entity.User;
import com.rose.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
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

//    @Test
//    public void test2() throws IOException {
//        String resource = "mapper/UserMapper.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List list = sqlSession.selectList("com.rose.mybatis.mapper.UserMapper.findAll");
//        System.out.println(list);
//    }

}
