package com.shrikant.designpatterns.gof.flyweight;

abstract public class User {

  //this is intrinsic information which is NOT provided by the client application but rather
  //calculated within application based on user type.
  protected int permissions;

  public User(int permissions) {
    this.permissions = permissions;
  }

  public abstract void performAction(ActionType action, String resource);
}
