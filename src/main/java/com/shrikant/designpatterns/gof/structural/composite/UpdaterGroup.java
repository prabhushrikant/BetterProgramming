package com.shrikant.designpatterns.gof.structural.composite;

import java.util.ArrayList;
import java.util.List;

import com.shrikant.designpatterns.gof.structural.flyweight.ActionType;
import com.shrikant.designpatterns.gof.structural.flyweight.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdaterGroup extends User {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdaterGroup.class);

    List<User> readers = new ArrayList<User>();

    public UpdaterGroup() {
        super(ActionType.UPDATE.getValue());
    }

    public List<User> getMembers() {
        return readers; 
    }

    public void addMember(User user) {
        readers.add(user);
    }

    public void removeMember(User user) {
        readers.remove(user);
    }

    public void performAction(ActionType actionType, String resource) {
        Boolean hasAccess = (permissions & actionType.getValue()) > 0;
        if (hasAccess) {
          LOGGER.info("Reader group performed action " + actionType + " on resource " + resource);
        } else {
          throw new CompositeException(String.format("Reader group not allowed to perform action %s on resource: %s", actionType, resource), 403);
        }
    }
}