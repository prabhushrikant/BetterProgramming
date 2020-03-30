package com.shrikant.designpatterns.gof.factory.abstract_factory;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

/**
 * Main Factory class.
 * This class defines the contract as in which different types of products are possible to be created by a factory.
 */
public abstract class CacheFactory<K, V> {  

  public abstract Cache<K, V> createDistributedCache(String cacheName, String host, int port) throws NotImplementedException;

  public abstract Cache<K, V> createInMemoryCache(String cacheName) throws NotImplementedException;
}