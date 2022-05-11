package com.usst.erhuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //启用事务管理器
@MapperScan(basePackages = "com.usst.erhuo.dao")
@SpringBootApplication
public class ErhuoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErhuoApplication.class, args);
    }

}
