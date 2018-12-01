package com.jyh.dubbostudy;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.jyh.dubbostudy.api")
public class DubbostudyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbostudyConsumerApplication.class, args);
    }
}
