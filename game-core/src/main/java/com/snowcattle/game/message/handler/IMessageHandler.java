package com.snowcattle.game.message.handler;

import java.lang.reflect.Method;

/**
 * Created by  on 17/2/8.
 */
public interface IMessageHandler {
    public Method getMessageHandler(int command);
}
