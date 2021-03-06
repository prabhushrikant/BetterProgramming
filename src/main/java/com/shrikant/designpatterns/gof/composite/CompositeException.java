package com.shrikant.designpatterns.gof.composite;

public class CompositeException extends RuntimeException {

  int httpStatus;

  public CompositeException(String message, int httpStatusCode) {
    super(message);
    this.httpStatus = httpStatusCode;
  }
}