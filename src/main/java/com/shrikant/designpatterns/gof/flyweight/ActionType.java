package com.shrikant.designpatterns.gof.flyweight;

//CRUD permissions bitwise OR of R(0001), U(0010), C(0100), D(1000).
public enum ActionType {
  READ(1),
  CREATE(4),
  UPDATE(2),
  DELETE(8);

  int value = 1;

  ActionType(int actionType) {
    this.value = actionType;
  }

  ADMIN =(READ |CREATE |UPDATE |DELETE)
}
