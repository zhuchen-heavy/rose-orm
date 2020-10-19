package com.rose.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 1：mybatis-spring-boot-starter示例：https://juejin.im/post/6844903805478404103
 * 2：增强型mybatis "mybatis-plus"：https://mybatis.plus/
 * </p>
 * <p>
 * 较好博客：
 * 1：https://blog.csdn.net/qq924862077/category_9266888_2.html
 * 2：https://www.jianshu.com/p/ec40a82cae28
 * 3：https://snailclimb.gitee.io/javaguide-interview/#/./docs/e-2mybatis
 *
 * @author: zhu.chen
 * @date: 2020/10/12
 * @version: v1.0.0
 */
//跟@Mapper差不多，同步于 com.rose.mybatis.entity.User.UserMapper上的@Mapper注解
@MapperScan(basePackages = {"com.rose.mybatis.mapper"})
@SpringBootApplication
public class RoseMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoseMybatisApplication.class, args);
    }

}
