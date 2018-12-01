package com.jyh.dubbostudy.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jyh.dubbostudy.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("hello")
public class HelloController {


    @Reference(version = "1.0.0",timeout = 100000)
    HelloService helloService;

    @RequestMapping("sayHello")
    public String sayHello(){
        //System.out.println("sayHello start"+ Thread.currentThread().getName() + "  "+new Date());
        helloService.sayHello();
        //System.out.println("sayHello end"+ Thread.currentThread().getName() + "  "+new Date());

        return "complete";
    }
}
