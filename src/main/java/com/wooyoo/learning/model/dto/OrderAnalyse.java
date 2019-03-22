package com.wooyoo.learning.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderAnalyse {

    private String productName;
    private BigDecimal price;
    private Integer counts;
    private String description;
    private Date createTime;
    private String isPayMoney;

    public String getProductName() {
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
    }

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
