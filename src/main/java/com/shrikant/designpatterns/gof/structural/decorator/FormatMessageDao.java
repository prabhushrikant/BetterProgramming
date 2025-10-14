package com.shrikant.designpatterns.gof.structural.decorator;

import java.util.UUID;
import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatMessageDao extends AbstractDecorator {

  final Logger LOGGER = LoggerFactory.getLogger(EmailMessageDao.class);

  public Message get(UUID id) {
    if (super.messageDao != null) {
      return super.messageDao.get(id);
    }

    throw new DecoratorException("Component is set to null.");
  }


  public Message create(@Nonnull String title, String body, String signature) {
    if (super.messageDao != null) {
      Message srcMessage = super.messageDao.create(title, body, signature);
      return srcMessage;
    }
    throw new DecoratorException("Component is set to null.");
  }


  public void delete(UUID id) {
    if (super.messageDao != null) {
      super.messageDao.delete(id);
    }
    throw new DecoratorException("Component is set to null.");
  }


  public Message update(Message msgToUpdateWithId) {
    if (super.messageDao != null) {
      super.messageDao.update(msgToUpdateWithId);
    }
    throw new DecoratorException("Component is set to null.");
  }

  /**
   * Added functionality by use of decorator pattern where message can also be formatted, however the core functionality of creating message is not changed hence code becomes
   * backward compatible.
   *
   * @param srcMessage obtained after calling original create() method on the MessageDaoComponent.
   * @param css        format of style sheet using which source message needs to be formatted.
   */
  public Message formatMessage(Message srcMessage, String css) {

    //todo:
    //deep copy message.
    Message copyOfMessage = new Message(srcMessage.id, srcMessage.title, srcMessage.body, srcMessage.signature);

    //custom logic to apply the css script to the message and have it annotated with correct formatting tags e.g. <bold></bold> etc.
    LOGGER.info("Message is successfully formatted as per given css");

    return copyOfMessage;
  }
}
