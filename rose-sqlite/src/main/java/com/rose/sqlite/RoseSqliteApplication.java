package com.rose.sqlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hikvision.config.file.ComponentDirectoryPathReader;
import org.springframework.boot.hikvision.config.file.ComponentInstallationDirectoryPathReader;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoseSqliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoseSqliteApplication.class, args);
    }

    @Bean
    public ComponentDirectoryPathReader componentDirectoryPathReader() {
        return new ComponentInstallationDirectoryPathReader();
    }

}
