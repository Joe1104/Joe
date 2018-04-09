package com.snowcattle.game.center.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.snowcattle.game.auto.LoginMessageProto;
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
@MessageCommandAnnotation(command = MessageCommandIndex.C2S_LoginMessage)
public class LoginMessageMessager extends AbstractNetProtoBufTcpMessage {
	
	private int webId;
	
	private String name;
	
	private String password;
	
	private int serverId;
	
	
    @Override
    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        LoginMessageProto.C2S_LoginMessage req = LoginMessageProto.C2S_LoginMessage.parseFrom(bytes);
        
        this.serverId = req.getServerId();
        this.name = req.getName();
        this.password = req.getPassword();
        this.webId = req.getWebid();
        
    }

    @Override
    public void release() throws CodecException {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {
//    	JoeResponseServer.JoeReq.Builder builder = JoeResponseServer.JoeReq.newBuilder();
//    	
////    	 if(!StringUtils.isEmpty(data)) {
//             builder.setChattype(123);
////         }
//    	 
////    	 if(!StringUtils.isEmpty(list)) {
////             builder.setList(list);
////         }
//    	 builder.setRoleName("sdsdssssssssssssssssss");
//    	 
//    	 if(!StringUtils.isEmpty(condition)) {
//    		  builder.setCondition(condition);
//         }
//         
//        byte[] bytes = builder.build().toByteArray();
//        getNetMessageBody().setBytes(bytes);
    }

	public int getWebId() {
		return webId;
	}

	public void setWebId(int webId) {
		this.webId = webId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}


}
