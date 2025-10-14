package com.shrikant.designpatterns.gof.creational.factory.abstract_factory;

import java.util.concurrent.ConcurrentHashMap;

public class CustomMemCache<K, V> extends Cache<K, V> {

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
