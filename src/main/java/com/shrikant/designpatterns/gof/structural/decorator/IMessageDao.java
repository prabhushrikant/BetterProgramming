package com.shrikant.designpatterns.gof.structural.decorator;

import java.util.UUID;

public interface IMessageDao {

  Message get(UUID id);

  Message create(String title, String body, String signature);

  void delete(UUID id);

  Message update(Message msgToUpdateWithId);
}
