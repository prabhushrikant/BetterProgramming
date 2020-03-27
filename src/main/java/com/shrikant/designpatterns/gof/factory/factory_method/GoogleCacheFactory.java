package com.shrikant.designpatterns.gof.factory.factory_method;


public class GoogleCacheFactory<K, V> extends MemoryCacheFactory<K, V> {

  @Override
  public MemoryCache<K, V> createCache(String cacheName) {
    return new GoogleCache<>(cacheName);
  }
  
}
