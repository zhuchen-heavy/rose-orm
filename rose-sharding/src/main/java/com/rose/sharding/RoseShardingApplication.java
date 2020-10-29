package com.rose.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *  博客参考：https://www.fangzhipeng.com/mysql.html
 * </p>
 *
 * @author: zhu.chen
 * @date: 2020/10/29
 * @version: v1.0.0
 */
@MapperScan(basePackages = "com.rose.sharding.mapper")
@SpringBootApplication
public class RoseShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoseShardingApplication.class, args);
    }

}
