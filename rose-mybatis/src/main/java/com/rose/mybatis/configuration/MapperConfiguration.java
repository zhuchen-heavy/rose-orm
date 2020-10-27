package com.rose.mybatis.configuration;

import com.rose.mybatis.plugin.MyInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MapperConfiguration {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            MyInterceptor myInterceptor = new MyInterceptor();
            Properties properties = new Properties();
            properties.setProperty("time","1");
            myInterceptor.setProperties(properties);
            configuration.addInterceptor(myInterceptor);
        };
    }

}
