package com.shrikant.designpatterns.gof.factory.factory_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryMethodApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(FactoryMethodApp.class);

  public static void main(String[] args) {

    //todo: Replace value type with Student object after Builder pattern is implemented.
    MemoryCache<String, String> googleCache = new GoogleCacheFactory<String, String>()
        .createCache("studentByEmailIdCache");

    //todo: Replace value type with Teacher object after Builder pattern is implemented.
    MemoryCache<String, String> customMemCache = new CustomMemCacheFactory<String, String>()
        .createCache("teacherByEmailIdCache");

    //populate google cache.
    googleCache.put("first.student@example.com", "studentId: S123, firstName: first, lastName: last");
    googleCache.put("second.student@example.com", "studentId: S456, firstName: second, lastName: last");

    customMemCache.put("first.teacher@example.com", "teacherId: T123, firstName: first, lastName: last");
    customMemCache.put("second.teacher@example.com", "teacherId: T456, firstName: second, lastName: last");

    LOGGER.info("Google cache name is: {}", googleCache.getCacheName());
    LOGGER.info("Custom Memory cache name is: {}", customMemCache.getCacheName());
  }
}
