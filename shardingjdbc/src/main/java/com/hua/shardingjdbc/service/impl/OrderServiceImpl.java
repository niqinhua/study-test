package com.hua.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shardingjdbc.dao.OrderMapper;
import com.hua.shardingjdbc.pojo.Order;
import com.hua.shardingjdbc.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author 倪勤华
 * @date 2020-03-07 0:23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
