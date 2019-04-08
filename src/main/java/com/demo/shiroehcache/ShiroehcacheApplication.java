package com.demo.shiroehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.demo.shiroehcache.dao")
@EnableSwagger2
public class ShiroehcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroehcacheApplication.class, args);
    }

}
