package com.shrikant.designpatterns.gof.structural.decorator;

public class DecoratorException extends RuntimeException {

  public DecoratorException(String message) {
    super(message);
  }

  public DecoratorException(String message, Throwable cause) {
    super(message, cause);
  }
}
