package com.myproject.foodnews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.myproject.foodnews.mapper")
public class FoodnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodnewsApplication.class, args);
    }

}
