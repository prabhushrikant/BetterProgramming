package com.shrikant.designpatterns.gof.singleton;

//singleton class needs to be final to avoid complete inheritance even by the internal derived class
//since just private constructor is not enough.
final public class SingletonExample {

  private static final Object lock = new Object();
  private static SingletonExample instance;

  //can't use new, can't inherit (except by an inner class.
  private SingletonExample() {
  }

  public static SingletonExample getInstance() {

    //thread safety.
    synchronized (lock) {
      if (instance == null) {
        instance = new SingletonExample();
      }
    }
    return instance;
  }
}