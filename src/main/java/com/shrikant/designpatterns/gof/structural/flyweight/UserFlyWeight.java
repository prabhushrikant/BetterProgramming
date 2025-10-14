package com.shrikant.designpatterns.gof.structural.flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Essenially a user factory class which simple factory method along with a thread safe cache to store pre-created user object
 * based on user type. 
 */
public class UserFlyWeight {

  private static ConcurrentHashMap<UserType, User> userCache = new ConcurrentHashMap<>();

  public static User createUser(UserType userType) {
    if (userCache.get(userType) == null) {
      User createdUser = null;  
      switch (userType) {
        case ADMIN:
          createdUser = new AdminUser();
          break;
        case GUEST:
        default:
          createdUser = new GuestUser();
      }
      userCache.put(userType, createdUser);
      return createdUser;
    }
    else {
      return userCache.get(userType);
    }
  }
}
