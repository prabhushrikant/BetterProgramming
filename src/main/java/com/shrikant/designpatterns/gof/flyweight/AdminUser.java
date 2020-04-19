package com.shrikant.designpatterns.gof.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminUser extends User {

  private static final Logger LOGGER = LoggerFactory.getLogger(AdminUser.class);

  public AdminUser() {
    super(ActionType.ADMIN.value);
  }

  public void performAction(ActionType actionType, String resource) {

    Boolean hasAccess = (permissions & actionType.value) > 0;
    if (hasAccess) {
      LOGGER.info("Admin performed action " + actionType + " on resource " + resource);
    } else {
      throw new FlyWeightException(String.format("Admin not allowed to perform action %s on resource: %s", actionType, resource), 403);
    }
  }
}
