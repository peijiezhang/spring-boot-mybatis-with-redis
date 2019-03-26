package com.wooyoo.learning.model.dto;

import com.wooyoo.learning.model.domain.Item;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OrderAnalyse {

    private Integer oId;
 /*   private String productName;
    private BigDecimal price;
    private Integer counts;
    private String description;*/
    private Date createTime;
    private String isPayMoney;
    public OrderAnalyse(){}
    private List<Item>  itemList = new LinkedList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public OrderAnalyse(Integer oId, Date createTime, String isPayMoney) {
        this.oId = oId;
        this.createTime = createTime;
        this.isPayMoney = isPayMoney;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

/*    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsPayMoney() {
        return isPayMoney;
    }

    public void setIsPayMoney(String isPayMoney) {
        this.isPayMoney = isPayMoney;
    }
}
