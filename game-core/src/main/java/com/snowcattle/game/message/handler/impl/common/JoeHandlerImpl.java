package com.snowcattle.game.message.handler.impl.common;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.db.service.jdbc.entity.Order;
import com.snowcattle.game.db.service.jdbc.service.entity.impl.OrderService;
import com.snowcattle.game.db.service.jdbc.test.TestConstants;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snowcattle.game.bootstrap.manager.LocalMananger;
import com.snowcattle.game.message.handler.AbstractMessageHandler;
import com.snowcattle.game.message.logic.tcp.common.CommonResponseServerMessage;
import com.snowcattle.game.message.logic.tcp.common.JoeResponseMessgae;
import com.snowcattle.game.service.message.AbstractNetMessage;
import com.snowcattle.game.service.message.command.MessageCommandIndex;
import com.snowcattle.game.service.message.factory.TcpMessageFactory;

/**
 * 第一个handle ！！！
 * @author Joe
 * 2018年2月28日
 * 下午3:47:58
 */
public class JoeHandlerImpl extends AbstractMessageHandler {

    @MessageCommandAnnotation(command = MessageCommandIndex.JOE_TEST2)
    public AbstractNetMessage handleMessage(JoeResponseMessgae message) throws Exception {
        
    	Long aa = new Date().getTime();
        System.out.println("-------------->:"+message.getCondition());
        JoeResponseMessgae joeResponse = new JoeResponseMessgae();
        joeResponse.setCondition(message.getCondition());
        System.out.println("-->message.cmd():" + message.getCmd());
        
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"bean/*.xml"});
//
//        OrderService orderService = (OrderService) classPathXmlApplicationContext.getBean("orderService");
//
//        
//        Order order = new Order();
//        order.setUserId(TestConstants.userId);
//        order.setId(1L);
//        order.setStatus("测试插入" );
//        orderService.insertOrder(order);
        
        return joeResponse;
        
    }
}
