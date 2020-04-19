package com.shrikant.designpatterns.gof.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestUser extends User {

  private static final Logger LOGGER = LoggerFactory.getLogger(GuestUser.class);

  public GuestUser() {
    super(001);
  }

  public void performAction(ActionType actionType, String resource) {

    Boolean hasAccess = (permissions & actionType.value) > 0;
    if (hasAccess) {
      LOGGER.info("Guest performed action " + actionType + "on resource " + resource);
    } else {
      throw new FlyWeightException(String.format("Guest user not allowed to perform action %s on resource: %s", actionType, resource), 403);
    }
  }
}
