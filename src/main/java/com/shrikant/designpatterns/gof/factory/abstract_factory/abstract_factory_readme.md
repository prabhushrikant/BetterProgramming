# Introduction

This is a small write up about abstract factory pattern I have tried to implement here.
There are 2 types of products (caches) possible 
- Distributed Cache (RedisCache)
- InMemory Cache (GoogleCache or CustomMemCache)

However purpose of this abstract factory is to allow creation of all types of caches without specifying the details as well as avoid mix and match of types of cache creation.

e.g. Combination of RedisCache and GoogleCache is required only for certain type of usage (say usage 1)
and combination of RedisCache and CustomMemCache is required only for other type of usage (say usage 2)

Because of which we have concrete factories for each usage, which only create caches of type needed for the usage. 

## Requirements

Because I am using Redis cache for distributed cache type. You need to have Redis installed on your machine and Redis server to be started befor running AbstractFactoryApp.java

## Details

AbstractFactoryApp.java -> driver class
CacheFactory.java -> Defines the interface saying which different types of caches(products) are possible at this factory of caches.

CacheFactoryType1.java -> Concrete implementation of the above interface which ensures that it creates caches of specified by interface but to be used for type 1 only. This ensures that mismatch of the caches are not possible.
i.e. CacheFactoryType1 will not be able to create cache of type 2.

CacheFactoryType2.java -> Concrete implementation of the above interface which ensures that it creates caches of specified by interface but to be used for type 2 only. This ensures that mismatch of the caches are not possible.
i.e. CacheFactoryType2 will not be able to create cache of type 1.

This pattern eliminates the drawback of factory_method pattern where mix and match of cache types is possible.

## Aditional Material 

Please follow this video for better and easy understanding of abstract factory pattern. The very well explains how it's an extension of factory method pattern.

https://www.youtube.com/watch?v=v-GiuMmsXj4
