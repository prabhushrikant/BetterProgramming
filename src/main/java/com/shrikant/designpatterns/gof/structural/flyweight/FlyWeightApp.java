package com.shrikant.designpatterns.gof.structural.flyweight;

import java.util.Random;

public class FlyWeightApp {


  /*
    Flyweight pattern when many objects of the same kind (intrinsic characteristics) are to be created with a slightly different characteristics (extrinsic)
    Objects with same intrinsic attributes are typically saved in cache (in memory or externally) and provided with changeable extrinsic attributes at the time of creation.
    This reduces the memory footprint as well object creation time is reduced.
   */
  public static void main(String[] args) {

    //simulator for user logins
    for (int i = 1; i < 1000; i++) {
      UserType loggedUserType = randomUserTypeGenerator();
      User createdUser = UserFlyWeight.createUser(loggedUserType); //simple factory

      createdUser.performAction(ActionType.CREATE, "/root/RandomResourceUri"); //todo: write a random resource generator function.
    }
  }

  static UserType randomUserTypeGenerator() {

    Random random = new Random();
    UserType randomUserType;
    switch (random.nextInt(2)) {
      case 0:
      default:
        randomUserType = UserType.GUEST;
        break;
      case 1:
        randomUserType = UserType.ADMIN;
        break;
    }

    return randomUserType;
  }
}
