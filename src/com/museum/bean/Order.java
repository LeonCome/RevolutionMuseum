package com.museum.bean;

import java.util.Date;
import java.util.List;

/**
 * Order - 订单实体类
 */
public class Order {
    private Integer id;
    private Integer status = 0;         // 1未发货，2已发货，3已签收，4完成
    private Double total;
    private Integer amount;
    private Date createTime;
    private User user;                  //关联的用户对象

    private List<OrderItem> orderItems;     //关联的订单项集合

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", total=" + total +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", user=" + user +
                ", orderItems=" + orderItems +
                '}';
    }

    public Order() {
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, Integer status, Double total, Integer amount, Date createTime, User user) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.amount = amount;
        this.createTime = createTime;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
