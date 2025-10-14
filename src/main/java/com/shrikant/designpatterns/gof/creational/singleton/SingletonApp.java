package com.shrikant.designpatterns.gof.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(SingletonApp.class);

  public static void main(String[] args) {

    //not possible, private constructor.
    //SingletonExample singletonExample = new SingletonExample();

    SingletonExample singleInstance = SingletonExample.getInstance();

    LOGGER.info("Singleton instance is obtained.");
  }
}
