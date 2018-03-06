package com.snowcattle.game.service.message.decoder;

import com.snowcattle.game.bootstrap.manager.LocalMananger;
import com.snowcattle.game.service.message.AbstractNetProtoBufMessage;
import com.snowcattle.game.service.message.NetMessageHead;
import com.snowcattle.game.service.message.NetProtoBufMessageBody;
import com.snowcattle.game.common.constant.Loggers;
import com.snowcattle.game.common.exception.CodecException;
import com.snowcattle.game.service.message.registry.MessageRegistry;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.stereotype.Service;

/**
 * Created by jiangwenping on 17/2/3.
 */

@Service
public class NetProtoBufTcpMessageDecoderFactory implements INetProtoBufTcpMessageDecoderFactory {

    public AbstractNetProtoBufMessage praseMessage(ByteBuf byteBuf) throws CodecException {
        //读取head
        NetMessageHead netMessageHead = new NetMessageHead();
        //head为两个字节，跳过
        byteBuf.skipBytes(2);
//        ByteBuf c = byteBuf.readBytes(2);
//        System.out.println("c:"+c.toString());
        
        int len = byteBuf.readInt();
        netMessageHead.setLength(len);
        System.out.println("len:"+len);
        
        byte version = byteBuf.readByte();
        netMessageHead.setVersion(version);
        System.out.println("version:"+version);
        
        //读取内容
        short cmd = byteBuf.readShort();
        netMessageHead.setCmd(cmd);
        System.out.println("cmd:"+cmd);
        
        netMessageHead.setSerial(byteBuf.readInt());

        MessageRegistry messageRegistry = LocalMananger.getInstance().getLocalSpringServiceManager().getMessageRegistry();
        AbstractNetProtoBufMessage netMessage = messageRegistry.getMessage(cmd);
        //读取body
        NetProtoBufMessageBody netMessageBody = new NetProtoBufMessageBody();
        int byteLength = byteBuf.readableBytes();
//        System.out.println("byteLength:"+byteLength);
        ByteBuf bodyByteBuffer = Unpooled.buffer(256);
        byte[] bytes = new byte[byteLength];
        bodyByteBuffer = byteBuf.getBytes(byteBuf.readerIndex(), bytes);
        netMessageBody.setBytes(bytes);
        netMessage.setNetMessageHead(netMessageHead);
        netMessage.setNetMessageBody(netMessageBody);
        try {
            netMessage.decoderNetProtoBufMessageBody();
            netMessage.releaseMessageBody();
        }catch (Exception e){
            throw new CodecException("message cmd " + cmd + "decoder error", e);
        }

        //增加协议解析打印
        if(Loggers.sessionLogger.isDebugEnabled()){
            Loggers.sessionLogger.debug("revice net message" + netMessage.toAllInfoString());
        }

        return netMessage;
    }
}
