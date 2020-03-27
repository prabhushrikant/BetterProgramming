package com.shrikant.designpatterns.gof.factory.factory_method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MemoryCacheFactory<K, V> {

  private static final Logger LOGGER = LoggerFactory.getLogger(MemoryCacheFactory.class);

  public abstract MemoryCache<K, V> createCache(String cacheName);

}

