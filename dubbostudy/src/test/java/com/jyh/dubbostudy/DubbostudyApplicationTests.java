package com.jyh.dubbostudy;

import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.jyh.dubbostudy.service.impl.HelloServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubbostudyApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        Wrapper w = Wrapper.getWrapper(HelloServiceImpl.class);
        for (Method m:Wrapper.class.getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println(Wrapper.class.);
    }
}
