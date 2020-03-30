package com.shrikant.designpatterns.gof.factory.abstract_factory;

import redis.clients.jedis.Jedis;

public class RedisCache<K, V> extends Cache<K, V>{

    private Jedis jedis = new Jedis();
    
    public RedisCache(String cacheName, String host, int port) {
        super(cacheName);
        //jedis = new Jedis(host, port);
        jedis = new Jedis();
    }

	@Override
	public V get(K key) {
		V value = (V) jedis.get(key.toString());
		return value;
    }
    
	@Override
	public void put(K key, V value) {
        jedis.set(key.toString(), value.toString());
    }
    
	@Override
	public void remove(K key) {
        jedis.del(key.toString());
	}


}