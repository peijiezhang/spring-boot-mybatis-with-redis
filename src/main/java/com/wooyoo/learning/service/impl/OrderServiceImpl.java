package com.wooyoo.learning.service.impl;

import com.wooyoo.learning.dao.OrderDao;
import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import com.wooyoo.learning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<OrderAnalyse> getOrderList(User user) {
        return orderDao.getOrderList(user) ;
    }
}
