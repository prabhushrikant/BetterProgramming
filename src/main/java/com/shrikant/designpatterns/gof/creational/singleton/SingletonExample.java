package com.shrikant.designpatterns.gof.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//singleton class needs to be final to avoid complete inheritance even by the internal derived class
//since just private constructor is not enough.
final public class SingletonExample {

  private static final Logger LOGGER = LoggerFactory.getLogger(SingletonExample.class);
  private static SingletonExample instance;

  //can't use new, can't inherit (except by an inner class.
  private SingletonExample() {
  }

  public static SingletonExample getInstance() {

    // thread safety also lazy initialization (i.e. Object (if not created) only when it's required
    // by the calling program not otherwise)
    if (instance == null) {
      synchronized (SingletonExample.class) {
        instance = new SingletonExample();
      }
    }
    return instance;
  }
}

/* Alternate approach - Early initialization
final public class SingletonExample {
  private static final Logger LOGGER = LoggerFactory.getLogger(SingletonExample.class);
  private static minRequiredAge
  //this is thread safe.
  private static SingletonExample instance = new SingletonExample();
  private SingletonExample() {
    LOGGER.debug("Created singleton once and for all.");
  }
  public static SingletonExample getInstance() {
    return instance;
  }
  //disadvantage:
  //this method has no intention of creating object but object will still get created.
  public static void getSimpleClassName() {
    return SingletonExample.class.getSimpleName();;
  }
}
*/