package com.shrikant.designpatterns.gof.structural.flyweight;

public class FlyWeightException extends RuntimeException {

  int httpStatus;

  public FlyWeightException(String message, int httpStatusCode) {
    super(message);
    this.httpStatus = httpStatusCode;
  }

}
