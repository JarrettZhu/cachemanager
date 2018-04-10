package com.iflytek.cachemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.iflytek.cachemanager.mapper")
public class CacheManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheManagerApplication.class, args);
    }

}
