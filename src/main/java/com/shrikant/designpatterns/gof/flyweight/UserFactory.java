package com.shrikant.designpatterns.gof.flyweight;

import com.shrikant.designpatterns.gof.flyweight.FlyWeightApp.UserType;
import java.util.concurrent.ConcurrentHashMap;

public class UserFactory {

  private static ConcurrentHashMap<UserType, User> userCache = new ConcurrentHashMap<>();

  public static User createUser(UserType userType) {
    User createdUser = null;
    if (userCache.get(userType) == null) {

      switch (userType) {
        case ADMIN:
          createdUser = new AdminUser();
          break;
        case GUEST:
        default:
          createdUser = new GuestUser();
      }
      userCache.put(userType, createdUser);
    }
    return createdUser;
  }
}
