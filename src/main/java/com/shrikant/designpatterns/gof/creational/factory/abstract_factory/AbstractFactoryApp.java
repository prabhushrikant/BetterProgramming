package com.shrikant.designpatterns.gof.creational.factory.abstract_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory of Factories pattern.
 */
public class AbstractFactoryApp {

  public static void main(final String[] args) {
    
    final Logger LOGGER = LoggerFactory.getLogger(AbstractFactoryApp.class);

    //start(RedisServer)
    Cache<String, String> distributedCacheFromUsage1 = new CacheFactoryForUsage1<String, String>().createDistributedCache("distributedCacheType1", 
      "127.0.0.1", 6379);

    distributedCacheFromUsage1.put("first.student@example.com", "studentId: S123, firstName: first, lastName: last");
    distributedCacheFromUsage1.put("second.student@example.com", "studentId: S456, firstName: second, lastName: last");

    Cache<String, String> inMemoryCacheFromUsage1 = new CacheFactoryForUsage1<String, String>().createInMemoryCache("inMemoryCacheOfType1_implementingGoogleCache");
    inMemoryCacheFromUsage1.put("third.student@example.com", "studentId: S789, firstName: third, lastName: last");
    inMemoryCacheFromUsage1.put("fourth.student@example.com", "studentId: S101112, firstName: fourth, lastName: last");  
    
    LOGGER.info("First student from Redis for Usage1: " + distributedCacheFromUsage1.get("first.student@example.com"));
    LOGGER.info("Third student from Google cache for Usage1: " + inMemoryCacheFromUsage1.get("third.student@example.com"));

    Cache<String, String> distributedCacheFromUsage2 = new CacheFactoryForUsage2<String, String>().createDistributedCache("distributedCacheType2", 
      "127.0.0.1", 6379);

    distributedCacheFromUsage2.put("first.teacher@example.com", "teacherId: T123, firstName: first, lastName: last");
    distributedCacheFromUsage2.put("second.teacher@example.com", "teacherId: T456, firstName: second, lastName: last");

    Cache<String, String> inMemoryCacheFromUsage2 = new CacheFactoryForUsage2<String, String>().createInMemoryCache("inMemoryCacheOfType2_implementingGoogleCache");
    inMemoryCacheFromUsage2.put("third.teacher@example.com", "teacherId: T678, firstName: third, lastName: last");
    inMemoryCacheFromUsage2.put("fourth.teacher@example.com", "teacherId: T9810, firstName: fourth, lastName: last");  

    LOGGER.info("First student from Redis for Usage2: " + distributedCacheFromUsage2.get("first.teacher@example.com"));
    LOGGER.info("Third student from Custom in memory cache for Usage2: " + distributedCacheFromUsage2.get("third.teacher@example.com"));
  }
}
