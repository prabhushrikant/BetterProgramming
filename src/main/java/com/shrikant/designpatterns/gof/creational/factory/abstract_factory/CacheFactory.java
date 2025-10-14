package com.shrikant.designpatterns.gof.creational.factory.abstract_factory;

/**
 * Main Factory class.
 * This class defines the contract as in which different types of products are possible to be created by a factory.
 */
public abstract class CacheFactory<K, V> {  

  public abstract Cache<K, V> createDistributedCache(String cacheName, String host, int port);

  public abstract Cache<K, V> createInMemoryCache(String cacheName);
}