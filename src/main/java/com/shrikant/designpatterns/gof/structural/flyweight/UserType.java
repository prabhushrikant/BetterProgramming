package com.shrikant.designpatterns.gof.structural.flyweight;

public enum UserType {
    GUEST(0),
    ADMIN(1);

    int value = 0; //default user is guest.

    UserType(int userType) {
      this.value = userType;
    }    

}