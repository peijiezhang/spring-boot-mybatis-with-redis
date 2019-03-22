package com.wooyoo.learning.dao;

import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;

import java.util.List;

public interface OrderDao {

    public List<OrderAnalyse> getOrderList(User user);
 }
