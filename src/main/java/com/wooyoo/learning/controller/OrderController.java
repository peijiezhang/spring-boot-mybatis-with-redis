package com.wooyoo.learning.controller;


import com.wooyoo.learning.context.UserContainer;
import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import com.wooyoo.learning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {




    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrderList")
    public List<OrderAnalyse>  getOrderList(){



        System.out.println(Thread.currentThread());

        return orderService.getOrderList(UserContainer.getUser());
    }

    @RequestMapping("/getProductList")
    public List<Item>  getProductList(@RequestBody Map<String,Integer> orderParam){

        return orderService.getProductList(orderParam);
    }

    @RequestMapping("/deletedProduct")
    public boolean  deletedProduct(@RequestBody Map<String,Integer> productParam){

        return orderService.deletedProduct(productParam);
    }


}
