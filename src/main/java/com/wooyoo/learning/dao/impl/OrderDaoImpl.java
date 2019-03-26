package com.wooyoo.learning.dao.impl;

import com.wooyoo.learning.dao.OrderDao;
import com.wooyoo.learning.model.domain.Item;
import com.wooyoo.learning.model.domain.Orders;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.dto.OrderAnalyse;
import com.wooyoo.learning.model.mapper.ItemMapper;
import com.wooyoo.learning.model.mapper.OrderItemMapper;
import com.wooyoo.learning.model.mapper.OrdersMapper;
import com.wooyoo.learning.model.mapper.UserMapper;
import com.wooyoo.learning.model.mapper.mapperExt.OrderItemMapperExt;
import com.wooyoo.learning.model.mapper.mapperExt.OrderMapperExt;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {


    @Autowired
    UserMapperExt userMapperExt;

    @Autowired
    OrderMapperExt orderMapperExt;

    @Autowired
    OrderItemMapperExt orderItemMapperExt;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    ItemMapper itemMapper;



    @Override
    public List<OrderAnalyse> getOrderList(User user) {

        List<OrderAnalyse> result = new LinkedList<>();
        Integer userId = userMapperExt.getUserId(user.getUsername(), user.getPassword());
       // List<Orders> orders = orderMapperExt.getOrders(userId);
        List<Integer> orderId = orderMapperExt.getOrderId(userId);
        for(Integer singleOrderId:orderId){
            List<Item> itemList = new LinkedList<>();
            Orders orders= ordersMapper.selectByPrimaryKey(singleOrderId);
            OrderAnalyse analyse = new OrderAnalyse(orders.getoId(),orders.getCreateTime(),orders.getIsPayMoney());
            List<Integer> itemId = orderItemMapperExt.getItemId(orders.getoId());
            for(Integer singleItemId :itemId){
                Item item = itemMapper.selectByPrimaryKey(singleItemId);
                itemList.add(item);
                analyse.setItemList(itemList);

            }
            result.add(analyse);
        }

        // List<Integer> orderId = orderMapperExt.getOrderId(userId);
        return result;

    }


    public List<Item> getProductList(Map<String,Integer> orderParam) {

        List<Item> result = new LinkedList<>();

        // List<Orders> orders = orderMapperExt.getOrders(userId);

        Integer OrderId = orderParam.get("oId");
        List<Integer> itemId = orderItemMapperExt.getItemId(OrderId);
        for(Integer singleItemId :itemId){
            Item item = itemMapper.selectByPrimaryKey(singleItemId);
            result.add(item);
        }
        return result;
    }

    @Override
    public boolean deletedProduct(Map<String, Integer> productParam) {

        try{
            Integer productId = productParam.get("iId");
            Integer orderId = productParam.get("oId");
            int isDelete = orderItemMapperExt.deleteProducts(productId,orderId);
            if(isDelete!=0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
