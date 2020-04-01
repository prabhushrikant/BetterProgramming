package com.shrikant.designpatterns.gof.decorator;

abstract class AbstractDecorator extends MessageDaoImpl {

  //component
  protected MessageDaoImpl messageDao;

  public final void setComponent(MessageDaoImpl messageDao) {
    messageDao = messageDao;
  }

}
