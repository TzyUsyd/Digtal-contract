package com.comp5619;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.comp5619.mapper")
public class Comp5619G12ApplicationTests  {

	 @Test
	 void contextLoads() {
	 }

}
