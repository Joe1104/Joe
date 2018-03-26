package com.snowcattle.game.message.handler.impl.demo;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;

import java.util.Date;

import com.snowcattle.game.bootstrap.manager.LocalMananger;
import com.snowcattle.game.message.handler.AbstractMessageHandler;
import com.snowcattle.game.message.logic.tcp.common.CommonResponseServerMessage;
import com.snowcattle.game.message.logic.tcp.common.JoeResponseMessgae;
import com.snowcattle.game.service.message.AbstractNetMessage;
import com.snowcattle.game.service.message.NetMessageBody;
import com.snowcattle.game.service.message.command.MessageCommandIndex;
import com.snowcattle.game.service.message.factory.TcpMessageFactory;

/**
 * 第一个handle ！！！
 * @author Joe
 * 2018年2月28日
 * 下午3:47:58
 */
public class HandleTestImpl extends AbstractMessageHandler {

    @MessageCommandAnnotation(command = MessageCommandIndex.JOE_TEST)
    public AbstractNetMessage handleMessage(JoeResponseMessgae message) throws Exception {
        
    	
    	NetMessageBody body = message.getNetMessageBody();
    	
    	 
    	
    	Long aa = new Date().getTime();
    	
        JoeResponseMessgae joeResponse = new JoeResponseMessgae();
        joeResponse.setList("xxx");
        joeResponse.setData("yyyy");
        joeResponse.setMsg(aa.toString());
        joeResponse.setState(message.getSerial());
//        System.out.println("-->message.getSerial():" + message.getSerial());
        return joeResponse;
        
    }
}
