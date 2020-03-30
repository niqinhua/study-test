package com.hua.tkmapper;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TkmapperApplicationTests {

    @Test
    void contextLoads() {
            int x=11&9;

            int y=x^3;
            System.out.println(y|12);
    }

}
