package com.museum.bean;

/**
 * OrderItem - 订单项实体类
 */
public class OrderItem {
    private Integer id;
    private Integer amount;
    private Goods goods;            //关联的商品对象
    private Order order;            //关联的订单对象

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", amount=" + amount +
                ", goods=" + goods +
                ", order=" + order +
                '}';
    }

    public OrderItem() {
    }

    public OrderItem(Integer id) {
        this.id = id;
    }

    public OrderItem(Integer id, Integer amount, Goods goods, Order order) {
        this.id = id;
        this.amount = amount;
        this.goods = goods;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
