package com.shrikant.designpatterns.gof.structural.decorator;

import java.util.UUID;
import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailMessageDao extends AbstractDecorator {

  final Logger LOGGER = LoggerFactory.getLogger(EmailMessageDao.class);

  //@Override
  public Message get(UUID id) {
    if (super.messageDao != null) {
      return super.messageDao.get(id);
    }

    throw new DecoratorException("Component is set to null.");
  }

  //@Override
  public Message create(@Nonnull String title, String body, String signature) {
    if (super.messageDao != null) {
      Message srcMessage = super.messageDao.create(title, body, signature);
      return srcMessage;
    }
    throw new DecoratorException("Component is set to null.");
  }

  //@Override
  public void delete(UUID id) {
    if (super.messageDao != null) {
      super.messageDao.delete(id);
    }
    throw new DecoratorException("Component is set to null.");
  }

  //@Override
  public Message update(Message msgToUpdateWithId) {
    if (super.messageDao != null) {
      super.messageDao.update(msgToUpdateWithId);
    }
    throw new DecoratorException("Component is set to null.");
  }

  /**
   * Added functionality by use of decorator pattern where message can also be emailed , however the core functionality of creating message is not changed hence code becomes
   * backward compatible, no tests to change.
   *
   * @param srcMessage obtained after calling original create() method on the MessageDaoComponent.
   * @param toList
   * @param ccList
   * @param bccList
   * @return
   */
  public void emailMessage(Message srcMessage, String toList, String ccList, String bccList) {

    //todo:
    //custom logic to add email headers to the message and generate an emailable message which can be then sent using emailClient.
    LOGGER.info("Message is successfully emailed to {}", toList);
  }
}
