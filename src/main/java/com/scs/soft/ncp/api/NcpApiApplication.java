package com.scs.soft.ncp.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scs.soft.ncp.api.mapper")
public class NcpApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcpApiApplication.class, args);
    }

}
