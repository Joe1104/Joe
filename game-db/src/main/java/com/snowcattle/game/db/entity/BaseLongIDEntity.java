package com.shengjie.game.db.entity;


import com.shengjie.game.db.common.annotation.EntitySave;
import com.shengjie.game.db.common.annotation.FieldSave;
import com.shengjie.game.db.common.annotation.MethodSaveProxy;

/**
 * Created by jiangwenping on 17/4/5.
 */
@EntitySave
public class BaseLongIDEntity extends AbstractEntity<Long> {

    @FieldSave
    private Long id;

    @Override
    public Long getId() {
        return id;
    }


    @MethodSaveProxy(proxy="id")
    public void setId(Long id) {
        this.id = id;
    }

}
