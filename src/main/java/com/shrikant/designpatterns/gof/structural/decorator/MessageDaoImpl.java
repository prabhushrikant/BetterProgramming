package com.shrikant.designpatterns.gof.structural.decorator;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDaoImpl implements IMessageDao {

  final Logger LOGGER = LoggerFactory.getLogger(MessageDaoImpl.class);

  @Override
  public Message get(UUID id) {
    LOGGER.info("Retrieved message with id: {} from datastore.", id);
    return new Message(UUID.randomUUID(), "Sample message title.", "Sample message body.", "sample sign.");
  }

  @Override
  public Message create(String title, String body, String signature) {
    UUID newId = UUID.randomUUID();
    LOGGER.info("Created message with id: {} in datastore.", newId);
    return new Message(newId, title, body, signature);
  }

  @Override
  public void delete(UUID id) {
    LOGGER.info("Deleted message with id: {} from datastore.", id);
  }

  @Override
  public Message update(Message msgToUpdateWithId) {
    LOGGER.info("Updated message with id: {} in datastore.", msgToUpdateWithId.id);
    return new Message(msgToUpdateWithId.id, msgToUpdateWithId.title, msgToUpdateWithId.body + "And more body", msgToUpdateWithId.signature);
  }
}
