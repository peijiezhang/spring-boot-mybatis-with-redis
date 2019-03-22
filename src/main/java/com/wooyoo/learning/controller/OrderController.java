package com.wooyoo.learning.controller;


import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import com.wooyoo.learning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    public List<OrderAnalyse>  getOrderList(User user){

        return orderService.getOrderList(user);
    }


}
