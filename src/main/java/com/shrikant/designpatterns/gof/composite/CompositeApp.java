package com.shrikant.designpatterns.gof.composite;

import com.shrikant.designpatterns.gof.flyweight.ActionType;
import com.shrikant.designpatterns.gof.flyweight.FlyWeightException;
import com.shrikant.designpatterns.gof.flyweight.GuestUser;
import com.shrikant.designpatterns.gof.flyweight.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Function to treat user and group (compositeuser) which can contain user also the same way.
 */
public class CompositeApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompositeApp.class);

    public static void main(final String[] args) {

        final User guest1 = new GuestUser();
        final User guest2 = new GuestUser();
        final User guest3 = new GuestUser();
        final User guest4 = new GuestUser();
        final User guest5 = new GuestUser();

        final UpdaterGroup updaterGroup1 = new UpdaterGroup();
        updaterGroup1.addMember(guest1);
        updaterGroup1.addMember(guest2);
        updaterGroup1.addMember(guest3);

        final UpdaterGroup updaterGroup2 = new UpdaterGroup();
        updaterGroup2.addMember(guest4);

        updaterGroup1.performAction(ActionType.UPDATE, "/root/resource1/uri/to/update");
        LOGGER.info("Number of members in Updater group 1: " + updaterGroup1.getMembers().size());

        updaterGroup2.performAction(ActionType.UPDATE, "/root/resource2/uri/to/update");
        LOGGER.info("Number of members in Updater group 2: " + updaterGroup2.getMembers().size());

        try {
            guest5.performAction(ActionType.UPDATE, "/root/resource2/uri/to/update");
        } catch (final FlyWeightException ex) {
            LOGGER.info("guest5 can't update the resource but guest 1 or guest 4 can because they are part of updater group");
        }
        
    }
}