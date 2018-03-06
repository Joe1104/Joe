package com.snowcattle.game.message.logic.tcp.common;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.common.exception.CodecException;
import com.snowcattle.game.common.util.StringUtils;
import com.snowcattle.game.message.auto.common.JoeResponseServer;
import com.snowcattle.game.service.message.AbstractNetProtoBufTcpMessage;
import com.snowcattle.game.service.message.command.MessageCommandIndex;

/**
 * 
 * @author Joe
 * 2018年2月28日
 * 下午3:35:02
 */
@MessageCommandAnnotation(command = MessageCommandIndex.JOE_TEST)
public class JoeResponseMessgae extends AbstractNetProtoBufTcpMessage {
	
	private int state;
	
	private String data;
	
	private String list;
	
	private String msg;
	

    @Override
    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        JoeResponseServer.JoeResponse req = JoeResponseServer.JoeResponse.parseFrom(bytes);
    }

    @Override
    public void release() throws CodecException {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {
    	JoeResponseServer.JoeResponse.Builder builder = JoeResponseServer.JoeResponse.newBuilder();
    	
    	 if(!StringUtils.isEmpty(data)) {
             builder.setData(data);
         }
    	 
    	 if(!StringUtils.isEmpty(list)) {
             builder.setList(list);
         }
    	 
    	 if(!StringUtils.isEmpty(msg)) {
             builder.setMsg(msg);
         }
    
         builder.setState(state);
         
        byte[] bytes = builder.build().toByteArray();
        getNetMessageBody().setBytes(bytes);
    }

	public int getState() {
		return state;
	}

	public String getData() {
		return data;
	}

	public String getList() {
		return list;
	}

	public String getMsg() {
		return msg;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setList(String list) {
		this.list = list;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
