package com.hua.shardingjdbc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.shardingjdbc.pojo.Order;
import com.hua.shardingjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 倪勤华
 * @date 2020-03-04 20:09
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/page")
    public IPage<Order> findOrderList(Page<Order> page) {
        return orderService.page(page);
    }


    @PostMapping
    public boolean save(@RequestBody Order order) {
        return orderService.save(order);
    }
}
