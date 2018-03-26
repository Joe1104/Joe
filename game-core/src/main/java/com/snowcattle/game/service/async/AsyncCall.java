package com.snowcattle.game.service.async;

/**
 * Created by  on 17/4/19.
 * 异步线程调用
 */
public interface AsyncCall extends Runnable{
    public void call() throws Exception;
}
