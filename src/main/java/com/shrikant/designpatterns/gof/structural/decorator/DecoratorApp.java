package com.shrikant.designpatterns.gof.structural.decorator;

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

    //format message
    FormatMessageDao formatMessageDao = new FormatMessageDao(messageDao);
    Message formattedMsg = formatMessageDao.formatMessage(rawMessage, "format_for_gmail.css");

    //let's say now you have to have formatted message to be emailed.
    //regular inheritance model would have forced you into diamond problem.
    //But with decorator it becomes easy.
    EmailMessageDao emailMessageDao = new EmailMessageDao(formatMessageDao);
    emailMessageDao.emailMessage(formattedMsg, "reciever1@gmail.com; reciever2@gmail.com", "cced@gmail.com", "bcced@gmail.com");

    ///print message
    //let's say now you have to print the message.
    //email message from raw dao.
    PrintDecorator printDecorator = new PrintDecorator(messageDao);
    printDecorator.printMessage(rawMessage);
    printDecorator.printMessage(formattedMsg);
  }
}
