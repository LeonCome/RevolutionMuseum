package com.museum.bean;

/**
 * 购物车的商品项
 */
public class CartItem {
    private Integer id;         //商品id
    private Goods goods;
    private Integer count;      //商品数量
    private Double totalPrice;   //商品总价
    private User user;

    public CartItem() {
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer id, Goods goods, Integer count, Double totalPrice, User user) {
        this.id = id;
        this.goods = goods;
        this.count = count;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", goods=" + goods +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                '}';
    }
}
