package com.shrikant.designpatterns.gof.decorator;

import java.util.UUID;

public class Message {

  public UUID id;

  public String title;

  public String body;

  public String signature;

  public Message(UUID id, String title, String body, String signature) {
    this.id = id;
    this.body = body;
    this.signature = signature;
  }
}
