package com.shrikant.designpatterns.gof.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decorator allows user to add new functionality dynamically instead of creating a complex hierarchical model of classes. It's more flexible than using inheritance based class
 * hierarchy which can result in multiple of sub classes and can quickly get confusing.
 * <p>
 * Decorator pattern saves you from having stuck in diamond problem (need for multiple inheritance.)
 */
public class DecoratorApp {

  final Logger LOGGER = LoggerFactory.getLogger(DecoratorApp.class);

  public static void main(String[] args) {

    MessageDaoImpl messageDao = new MessageDaoImpl();
    Message rawMessage = messageDao.create("this is title of message# 1", "this is body of message# 1.", "signature for message# 1");

    //email message
    EmailMessageDao emailMessageDao = new EmailMessageDao();
    //composition instead of inheritance.
    emailMessageDao.setComponent(messageDao);
    emailMessageDao.emailMessage(rawMessage, "reciever1@gmail.com; reciever2@gmail.com", "cced@gmail.com", "bcced@gmail.com");

    //format message
    FormatMessageDao formatMessageDao = new FormatMessageDao();
    formatMessageDao.setComponent(messageDao);
    Message formattedMsg = formatMessageDao.formatMessage(rawMessage, "format_for_gmail.css");

    //let's say now you have to have formatted message to be emailed.
    //regular inheritance model would have forced you into diamond problem.
    //But with decorator it becomes easy.
    emailMessageDao.emailMessage(formattedMsg, "reciever1@gmail.com; reciever2@gmail.com", "cced@gmail.com", "bcced@gmail.com");
  }
}
