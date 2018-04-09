package com.snowcattle.game.center.orders;

import org.springframework.beans.factory.annotation.Autowired;

import com.snowcattle.game.auto.JoeResponseServer;
import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.common.exception.CodecException;
import com.snowcattle.game.common.util.StringUtils;
import com.snowcattle.game.service.message.AbstractNetProtoBufTcpMessage;
import com.snowcattle.game.service.message.command.MessageCommandIndex;
import com.snowcattle.game.service.net.tcp.session.builder.NettyTcpSessionBuilder;

/**
 * 
 * @author Joe
 * 2018年2月28日
 * 下午3:35:02
 */
@MessageCommandAnnotation(command = MessageCommandIndex.C2S_AchieveListMessage)
public class JoeMessager extends AbstractNetProtoBufTcpMessage {
	
	private int state;
	
	private String data;
	
	private String list;
	
	private String msg;
	
	private String condition;
	

    @Override
    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        JoeResponseServer.JoeReq req = JoeResponseServer.JoeReq.parseFrom(bytes);
        
        this.condition = req.getCondition();
        
    }

    @Override
    public void release() throws CodecException {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {
    	JoeResponseServer.JoeReq.Builder builder = JoeResponseServer.JoeReq.newBuilder();
    	
//    	 if(!StringUtils.isEmpty(data)) {
             builder.setChattype(123);
//         }
    	 
//    	 if(!StringUtils.isEmpty(list)) {
//             builder.setList(list);
//         }
    	 builder.setRoleName("sdsdssssssssssssssssss");
    	 
    	 if(!StringUtils.isEmpty(condition)) {
    		  builder.setCondition(condition);
         }
         
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
