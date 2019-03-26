package com.wooyoo.learning.model.mapper.mapperExt;


import com.wooyoo.learning.model.domain.Orders;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface OrderMapperExt {

    @Select("SELECT orders.o_id,orders.create_time,orders.is_pay_money FROM  orders where orders.user_id = #{userId}")
    List<Orders> getOrders(@Param("userId") Integer userId);

    @Select("SELECT orders.o_id FROM orders WHERE orders.user_id=#{userId}")
    List<Integer> getOrderId(@Param("userId") Integer userId);


}
