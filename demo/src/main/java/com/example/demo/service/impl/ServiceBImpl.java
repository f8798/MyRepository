package com.example.demo.service.impl;

import com.example.demo.service.ServiceB;
import org.springframework.stereotype.Service;

@Service
public class ServiceBImpl implements ServiceB {
    @Override
    public void doB() {
        System.out.println("doB");

    }
}
