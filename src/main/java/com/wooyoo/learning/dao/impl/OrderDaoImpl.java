package com.wooyoo.learning.dao.impl;

import com.wooyoo.learning.dao.OrderDao;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {


    @Override
    public List<OrderAnalyse> getOrderList(User user) {


        return null;
    }
}
