package com.shrikant.designpatterns.gof.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintDecorator extends AbstractDecorator {

    final Logger LOGGER = LoggerFactory.getLogger(EmailMessageDao.class);

    public PrintDecorator(IMessageDao messageDao) {
        super(messageDao);
    } 

    /**
   * Added functionality by use of decorator pattern where message can also be printed, however the core functionality of creating message is not changed hence code becomes
   * backward compatible.
   *
   * @param srcMessage obtained after calling original create() method on the MessageDaoComponent.
   * @param css        format of style sheet using which source message needs to be formatted.
   */
  public void printMessage(Message srcMessage) {

    //todo:
    //custom logic to print the message.
    LOGGER.info("Message with id {} is successfully printed.", srcMessage.id);
  }

    @Override
  public void decorate() {
    // Implement your decoration logic here
    LOGGER.info("Decorate method called in PrintMessageDao.");
  }
}
