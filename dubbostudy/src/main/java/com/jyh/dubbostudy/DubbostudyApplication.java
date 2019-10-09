package com.jyh.dubbostudy;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.jyh.dubbostudy.service.impl")
public class DubbostudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbostudyApplication.class, args);
    }
}
