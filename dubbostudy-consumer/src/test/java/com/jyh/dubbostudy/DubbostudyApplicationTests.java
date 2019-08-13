package com.jyh.dubbostudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubbostudyApplicationTests {

    private String a;
    public DubbostudyApplicationTests() {
    }

    public DubbostudyApplicationTests(String a) {
        Class c = a.getClass();

    }

    @Test
    public void contextLoads() {
    }

}
