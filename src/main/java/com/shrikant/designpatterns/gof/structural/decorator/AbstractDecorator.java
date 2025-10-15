package com.shrikant.designpatterns.gof.structural.decorator;

abstract class AbstractDecorator extends MessageDaoImpl {

  //composition over inheritance ? do we need composition though?
  //component
  protected IMessageDao messageDao;

  public AbstractDecorator(IMessageDao messageDao) {
    super();
  }

  //operation to be implemented by concrete decorators
  abstract public void decorate();

  public final void setComponent(MessageDaoImpl messageDao) {
    this.messageDao = messageDao;
  }

}
