package com.wooyoo.learning.model.domain;

public class OrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.order_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.order_item_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    private Integer orderItemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.product_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    private Integer productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.order_id
     *
     * @return the value of order_item.order_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.order_id
     *
     * @param orderId the value for order_item.order_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.order_item_id
     *
     * @return the value of order_item.order_item_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public Integer getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.order_item_id
     *
     * @param orderItemId the value for order_item.order_item_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.product_id
     *
     * @return the value of order_item.product_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.product_id
     *
     * @param productId the value for order_item.product_id
     *
     * @mbggenerated Fri Mar 22 13:57:17 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}