package com.comp5619;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.comp5619.mapper")
public class Comp5619G12Application  {

    public static void main(String[] args) {
        SpringApplication.run(Comp5619G12Application.class, args);
    }

}
