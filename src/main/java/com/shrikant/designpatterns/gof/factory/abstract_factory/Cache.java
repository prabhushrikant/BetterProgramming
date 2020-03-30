package com.shrikant.designpatterns.gof.factory.abstract_factory;

public abstract class Cache<K, V> {

    String cacheName;

    protected Cache(String cacheName) {
      this.cacheName = cacheName;
    }
  
    public String getCacheName() {
      return this.cacheName;
    }
  
    public abstract V get(K key);
  
    public abstract void put(K key, V value);
  
    public abstract void remove(K key);
}