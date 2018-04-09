package com.snowcattle.game.center.login;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.common.constant.Loggers;
import com.snowcattle.game.common.util.BeanUtil;
import com.snowcattle.game.db.orders.OrderX;
import com.snowcattle.game.db.orders.OrderXService;
import com.snowcattle.game.db.service.common.uuid.SnowFlakeUUIDService;
import com.snowcattle.game.db.service.jdbc.entity.Order;
import com.snowcattle.game.db.service.jdbc.service.entity.impl.OrderService;
import com.snowcattle.game.db.service.jdbc.test.TestConstants;

import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snowcattle.game.bootstrap.manager.LocalMananger;
import com.snowcattle.game.bootstrap.manager.spring.LocalSpringBeanManager;
import com.snowcattle.game.message.handler.AbstractMessageHandler;
import com.snowcattle.game.message.logic.tcp.common.CommonResponseServerMessage;
import com.snowcattle.game.service.message.AbstractNetMessage;
import com.snowcattle.game.service.message.command.MessageCommandIndex;
import com.snowcattle.game.service.message.factory.TcpMessageFactory;

/**
 * 
 * @author Administrator
 *
 */
public class LoginMessageHandler extends AbstractMessageHandler {
	
	
	public static final Logger logger = Loggers.logstash;
	
	
//	@Autowired
//	private OrderXService orderXService;

    @MessageCommandAnnotation(command = MessageCommandIndex.C2S_LoginMessage)
    public AbstractNetMessage handleMessage(LoginMessageMessager message) throws Exception {
        
    	
    	Long aa = new Date().getTime();
        System.out.println("-------------->:"+message.getCmd());
        
        
        
        int webId = message.getWebId();
        
       // TODO 验证重复登录 
        
        
        
        LoginService loginService = (LoginService) BeanUtil.getBean("loginService");
        loginService.login();
        
        
        LoginMessageMessager joeResponse = new LoginMessageMessager();
//        joeResponse.setCondition(message.getCmd());
        System.out.println("-->message.cmd():" + message.getCmd());
        
        OrderXService orderXService = (OrderXService) BeanUtil.getBean("orderXService");

        SnowFlakeUUIDService snowFlakeUUIDService = (SnowFlakeUUIDService) BeanUtil.getBean("snowFlakeUUIDService");
        
        Long uuid = snowFlakeUUIDService.nextId();
        System.out.println("-->uuid:" + uuid);
        OrderX  order = new OrderX ();
        order.setUserId(TestConstants.userId);
        order.setId(uuid);
        order.setStatus("测试插入xxx");
        orderXService.insertOrder(order);
        
        logger.info("===================================>>>>>>>");
        
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
