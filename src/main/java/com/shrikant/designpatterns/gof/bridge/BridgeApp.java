package com.shrikant.designpatterns.gof.bridge;

/**
 * Bridge pattern is used when we want a service and its client evolve 
 * on their own heirarchies. e.g. Lets say we have CacheService which can be implemented by RedisCacheServiceImpl
 * and MemCacheServiceImpl.java. CacheService has cache client which internally calls the cache service
 * however some might create AsycCacheClient while someone might want synchronous cache client. There could be 
 * another user who might need cache client with connection pools or someone might need CachClientWithRetry()
 * 
 * Bridge here is that cache client will contain instance of the service it's talking to. This pattern makes use 
 * of composition.  
 */
public class BridgeApp {

}