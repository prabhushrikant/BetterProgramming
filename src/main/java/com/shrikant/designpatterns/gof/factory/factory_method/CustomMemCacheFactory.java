package com.shrikant.designpatterns.gof.factory.factory_method;

public class CustomMemCacheFactory<K, V> extends MemoryCacheFactory<K, V> {

  @Override
  public MemoryCache<K, V> createCache(String cacheName) {
    return new CustomMemCache<>(cacheName);
  }
}
