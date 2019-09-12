package com.github.cnygf.anls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.cnygf.anls.mapper")
public class AnlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnlsApplication.class, args);
    }

}
