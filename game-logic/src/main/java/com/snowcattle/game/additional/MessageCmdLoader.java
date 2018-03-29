package com.snowcattle.game.additional;

import java.util.concurrent.ConcurrentHashMap;

import com.snowcattle.game.bootstrap.manager.LocalMananger;
import com.snowcattle.game.bootstrap.manager.spring.LocalSpringBeanManager;
import com.snowcattle.game.bootstrap.manager.spring.LocalSpringServiceManager;
import com.snowcattle.game.service.message.command.MessageCommand;
import com.snowcattle.game.service.message.command.MessageCommandFactory;

public class MessageCmdLoader {
	
    public final void loadMessageCommand(){

      LocalSpringBeanManager localSpringBeanManager = LocalMananger.getInstance().getLocalSpringBeanManager();
      MessageCommandFactory messageCommandFactory = localSpringBeanManager.getMessageCommandFactory();
      MessageCommand[] messageCommands = messageCommandFactory.getAllCommands();
      LocalSpringServiceManager localSpringServiceManager = LocalMananger.getInstance().getLocalSpringServiceManager();
      
      
//      ConcurrentHashMap<Short, MessageCommand> messageCommandMap = localSpringServiceManager.getMessageRegistry().
//      
//      for(MessageCommand messageCommand: messageCommands){
//          messageCommandMap.put((short) messageCommand.getCommand_id(), messageCommand);
//          logger.info("messageCommands load:" + messageCommand);
//      }
  }

}
