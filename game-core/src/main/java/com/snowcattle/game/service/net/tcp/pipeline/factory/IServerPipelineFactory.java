package com.snowcattle.game.service.net.tcp.pipeline.factory;


import com.snowcattle.game.service.net.tcp.pipeline.IServerPipeLine;

/**
 * Created by  on 17/2/14.
 */
public interface IServerPipelineFactory {
    public IServerPipeLine createServerPipeLine();
}
