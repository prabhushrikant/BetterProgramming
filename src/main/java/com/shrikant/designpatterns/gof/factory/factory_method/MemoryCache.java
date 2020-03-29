package com.shrikant.designpatterns.gof.factory.factory_method;

public abstract class MemoryCache<K, V> {

  String cacheName;

  protected MemoryCache(String cacheName) {
    this.cacheName = cacheName;
  }

  public String getCacheName() {
    return this.cacheName;
  }

  public abstract V get(K key);

  public abstract void put(K key, V value);

  public abstract void remove(K key);
}
