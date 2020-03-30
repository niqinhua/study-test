package com.hua.shardingjdbc;

import com.hua.shardingjdbc.pojo.Order;
import com.hua.shardingjdbc.service.OrderService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void testOrderInsert() {

//        for (int i=0;i<10;i++) {
            Order order = new Order();
            order.setCreateTime(LocalDateTime.now());
            order.setPrice(new BigDecimal(1L));
            order.setUserId(1L);
            order.setStatus(1);
            orderService.save(order);
//        }
    }
    @Test
    public void testOrderQuery() {
        new StringBuffer();
//        Order order = orderService.getById(443182493525344257L);
        BigDecimal bigDecimal = new BigDecimal(2.3f);
        System.out.println(bigDecimal.toString());
//        ArrayList<Long> ids = new ArrayList<>();
//        ids.add(443041701662031873L);
//        ids.add(443041701691392000L);
//        orderService.listByIds(ids);
//        System.out.println(order.toString());

//        orderService.getOne(Wrappers.<Order>lambdaQuery().eq(Order::getPrice, new BigDecimal(0)));
    }

    @Test
    public void testTime() {

            System.out.println(((11&9)^3)|12);

    }
}
