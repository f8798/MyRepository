package com.jyh.dubbostudy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jyh.dubbostudy.service.HelloService;

@Service(timeout = 10000, version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    public String sayHello(){
        byte[] bigBlock = new byte[1000*8];
        for (int i = 0; i < bigBlock.length; i++) {
            bigBlock[i] = 'b';
        }

       // System.out.println("HelloServiceImpl.sayHello()");
        return new String(bigBlock);
    }
}
