package com.snowcattle.game.db.orders;

import com.snowcattle.game.db.service.entity.EntityService;
import com.snowcattle.game.db.sharding.EntityServiceShardingStrategy;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 17/3/20.
 */
@Service
public class OrderXService extends EntityService<OrderX> implements IOrderXService{


    public long insertOrder(OrderX order) {
        return insertEntity(order);
    }

    @Override
    public OrderX getOrder(long userId, long id) {
    	OrderX order = new OrderX();
        order.setUserId(userId);
        order.setId(id);
        return (OrderX) getEntity(order);
    }

    @Override
    public List<OrderX> getOrderList(long userId) {
    	OrderX order = new OrderX();
        order.setUserId(userId);
        return getEntityList(order);
    }

    @Override
    public List<OrderX> getOrderList(long userId, String status) {
    	OrderX order = new OrderX();
        order.setUserId(userId);
        order.setStatus(status);
        return getEntityList(order);
    }

    @Override
    public void updateOrder(OrderX order) {
        updateEntity(order);
    }

    @Override
    public void deleteOrder(OrderX order) {
        deleteEntity(order);
    }

    @Override
    public List<Long> insertOrderList(List<OrderX> order) {
        return insertEntityBatch(order);
    }

    @Override
    public void updateOrderList(List<OrderX> order) {
        updateEntityBatch(order);
    }

    @Override
    public void deleteOrderList(List<OrderX> order) {
        deleteEntityBatch(order);
    }

    @Override
    public EntityServiceShardingStrategy getEntityServiceShardingStrategy() {
        return getDefaultEntityServiceShardingStrategy();
    }
}
