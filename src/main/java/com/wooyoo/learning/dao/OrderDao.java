package com.wooyoo.learning.dao;

import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.domain.Orders;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public List<OrderAnalyse> getOrderList(User user);

    public List<Item> getProductList(Map<String,Integer> orderParam);

    public boolean deletedProduct(Map<String,Integer> productParam);
 }
