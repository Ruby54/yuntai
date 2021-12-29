package com.atguigu.yuntai.statistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.yuntai.statistics.mapper")
public class YunTaiStatisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YunTaiStatisticsApplication.class, args);
    }
}
