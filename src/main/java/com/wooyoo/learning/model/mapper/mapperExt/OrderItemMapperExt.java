package com.wooyoo.learning.model.mapper.mapperExt;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderItemMapperExt {

    @Select("SELECT order_item.item_id FROM order_item WHERE order_item.order_id=#{orderId};")
    List<Integer> getItemId(@Param("orderId") Integer OrderId);

    @Delete("DELETE FROM order_item where order_item.item_id=#{itemId} AND order_item.order_id=#{orderId};")
    int deleteProducts(@Param("itemId") Integer itemId,@Param("orderId") Integer orderId);


}
