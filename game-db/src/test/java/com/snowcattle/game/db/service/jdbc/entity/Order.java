package com.shengjie.game.db.service.jdbc.entity;

import com.shengjie.game.db.service.redis.AsyncSave;
import com.shengjie.game.db.service.redis.RedisInterface;
import com.shengjie.game.db.service.redis.RedisKeyEnum;
import com.shengjie.game.db.common.annotation.DbMapper;
import com.shengjie.game.db.common.annotation.EntitySave;
import com.shengjie.game.db.common.annotation.FieldSave;
import com.shengjie.game.db.common.annotation.MethodSaveProxy;
import com.shengjie.game.db.entity.BaseLongIDEntity;
import com.shengjie.game.db.service.jdbc.mapper.OrderMapper;
import com.shengjie.game.db.util.EntityUtils;

@EntitySave
@DbMapper(mapper = OrderMapper.class)
public class Order extends BaseLongIDEntity implements RedisInterface, AsyncSave {

    @FieldSave
    private String status;

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    @MethodSaveProxy(proxy="status")
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + getId() +
                ", userId=" + getUserId() +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public String getUnionKey() {
        return String.valueOf(getUserId()+ EntityUtils.ENTITY_SPLIT_STRING + getId());
    }

    @Override
    public String getRedisKeyEnumString() {
        return RedisKeyEnum.PLAYER.getKey();
    }

}