package com.shengjie.game.db.entity;

import com.shengjie.game.db.common.annotation.EntitySave;
import com.shengjie.game.db.common.annotation.FieldSave;
import com.shengjie.game.db.common.annotation.MethodSaveProxy;

/**
 * Created by sunmosh on 2017/4/5.
 */
@EntitySave
public class BaseStringIDEntity extends AbstractEntity<String> {

    @FieldSave
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @MethodSaveProxy(proxy="id")
    @Override
    public void setId(String id) {
        this.id = id;
    }
}
