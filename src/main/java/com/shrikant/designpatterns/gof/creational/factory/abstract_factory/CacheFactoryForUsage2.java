package com.shrikant.designpatterns.gof.creational.factory.abstract_factory;

/**
 * Concrete implementation of type 2 of the caches.
 */
public class CacheFactoryForUsage2<K, V> extends CacheFactory<K, V> {

    @Override
    public Cache<K, V> createDistributedCache(String cacheName, String host, int port) {
        return new RedisCache<>(cacheName, host, port);
    }

    @Override
    public Cache<K, V> createInMemoryCache(String cacheName) {
        return new CustomMemCache<K,V>(cacheName);
    }
}