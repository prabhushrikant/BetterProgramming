package com.shrikant.designpatterns.gof.creational.factory.abstract_factory;

/**
 * Concrete implementation of type 1 of the caches.
 * 
 * This class groups the creation of the products of Type 1, this is to avoid so that products of type 1 are not allowed 
 * to be created with products of Type 2.
 * 
 * Factory 
 */
public class CacheFactoryForUsage1<K, V> extends CacheFactory<K, V> {

    @Override
    public Cache<K, V> createDistributedCache(String cacheName, String host, int port) {
        return new RedisCache<>(cacheName, host, port);
    }

    @Override
    public Cache<K, V> createInMemoryCache(String cacheName) {
        return new GoogleCache<K,V>(cacheName);
    }
}