package com.snowcattle.game.db.orders;


import java.util.List;

/**
 * Created by  on 17/3/20.
 */
public interface IOrderXService {
    public long insertOrder(OrderX order);
    public OrderX getOrder(long userId, long id);
    public List<OrderX> getOrderList(long userId);
    public List<OrderX> getOrderList(long userId, String status);
    void updateOrder(OrderX order);
    void deleteOrder(OrderX order);

    public List<Long> insertOrderList(List<OrderX> order);
    public void updateOrderList(List<OrderX> order);
    public void deleteOrderList(List<OrderX> order);
}

