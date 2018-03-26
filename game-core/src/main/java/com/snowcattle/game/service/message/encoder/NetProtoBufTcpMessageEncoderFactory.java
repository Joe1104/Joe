package com.snowcattle.game.service.message.encoder;

import com.snowcattle.game.service.message.AbstractNetProtoBufMessage;
import com.snowcattle.game.service.message.NetMessageBody;
import com.snowcattle.game.service.message.NetMessageHead;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


import org.springframework.stereotype.Service;

/**
 * Created by  on 17/2/8.
 *   capacity = messageData.length + 8;
                    tmp_buffer.writeInt(capacity);
                    tmp_buffer.writeShort(message.msgId);
                    tmp_buffer.writeBytes(options);
 */
@Service
public class NetProtoBufTcpMessageEncoderFactory implements INetProtoBufTcpMessageEncoderFactory {

    @Override
    public ByteBuf createByteBuf(AbstractNetProtoBufMessage netMessage) throws Exception {
    	
    	
    	netMessage.encodeNetProtoBufMessageBody();
    	NetMessageBody netMessageBody = netMessage.getNetMessageBody();
    	
        ByteBuf byteBuf = Unpooled.buffer(256);
        //编写head
        NetMessageHead netMessageHead = netMessage.getNetMessageHead();
//        byteBuf.writeShort(netMessageHead.getHead());
        //长度
        int length = netMessageBody.getBytes().length;
        byteBuf.writeInt(length+8);
        
        //设置内容
//        byteBuf.writeByte(netMessageHead.getVersion());
        byteBuf.writeShort(netMessageHead.getCmd());
        System.out.println("---?sendCnd:"+netMessageHead.getCmd());
        
        byteBuf.writeByte(0);
        byteBuf.writeByte(0);
        
//        byteBuf.writeInt(netMessageHead.getSerial());
        
        //编写body
        byteBuf.writeBytes(netMessageBody.getBytes());

        //重新设置长度
//        int skip = 6;
//        int length = byteBuf.readableBytes() - skip ;
//        byteBuf.setLong(1, length);
        byteBuf.slice();
        System.out.println("---?length:"+length);
        return byteBuf;
    }
}

