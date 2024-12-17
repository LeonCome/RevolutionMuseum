package com.museum.bean;

/**
 * OrderItem - 订单项实体类
 */
public class OrderItem {
    private Integer id;
    private User user;
    private Goods goods;
    private OrderStatus orderStatus;
    private Integer count;
    private Double totalPrice;

    public OrderItem() {
    }

    public OrderItem(Integer id) {
        this.id = id;
    }

    public OrderItem(Integer id, User user, Goods goods, OrderStatus orderStatus, Integer count, Double totalPrice) {
        this.id = id;
        this.user = user;
        this.goods = goods;
        this.orderStatus = orderStatus;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", user=" + user +
                ", goods=" + goods +
                ", orderStatus=" + orderStatus +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
