package com.example.demo.service.impl;

import com.example.demo.service.ServiceA;
import org.springframework.stereotype.Service;

@Service
public class ServiceAImpl implements ServiceA {
    @Override
    public void doA() {
        System.out.println("doA");
    }
}
