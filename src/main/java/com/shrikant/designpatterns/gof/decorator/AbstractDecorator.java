package com.shrikant.designpatterns.gof.decorator;

import java.util.UUID;

abstract class AbstractDecorator extends MessageDaoImpl {

  //component
  protected MessageDaoImpl messageDao;

  public final void setComponent(MessageDaoImpl messageDao) {
    messageDao = messageDao;
  }

  @Override
  public abstract Message get(UUID id);

  @Override
  public abstract Message create(UUID id);

  @Override
  public abstract Message get(UUID id);

  @Override
  public abstract Message get(UUID id);
}
