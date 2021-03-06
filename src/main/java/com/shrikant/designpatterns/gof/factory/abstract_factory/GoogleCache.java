package com.shrikant.designpatterns.gof.factory.abstract_factory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GoogleCache<K, V> extends com.shrikant.designpatterns.gof.factory.abstract_factory.Cache<K, V> {

  Cache<K, V> cache;

  protected GoogleCache(String cacheName) {
    super(cacheName);
    cache = CacheBuilder.newBuilder().maximumSize(100).build();
  }

  @Override
  public V get(K key) {
    return cache.getIfPresent(key);
  }

  @Override
  public void put(K key, V value) {
    cache.put(key, value);
  }

  @Override
  public void remove(K key) {
    cache.invalidate(key);
  }

}
