package com.example.demo.controller;

import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;

    @RequestMapping("/doSomething")
    public void doSomething(){
        serviceA.doA();
        serviceB.doB();
    }
}
