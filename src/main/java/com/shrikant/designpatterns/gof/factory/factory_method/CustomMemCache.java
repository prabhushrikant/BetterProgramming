package com.shrikant.designpatterns.gof.factory.factory_method;

import java.util.concurrent.ConcurrentHashMap;

public class CustomMemCache<K, V> extends MemoryCache<K, V> {

  private ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();

  protected CustomMemCache(String cacheName) {
    super(cacheName);
  }

  @Override
  public V get(K key) {
    return cache.get(key);
  }

  @Override
  public void put(K key, V value) {
    cache.put(key, value);
  }

  @Override
  public void remove(K key) {
    cache.remove(key);
  }
}
