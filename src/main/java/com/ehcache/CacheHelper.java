package com.ehcache;

import lombok.Getter;
import lombok.Setter;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

@Getter
@Setter
public class CacheHelper {

    private CacheManager cacheManager;
    private Cache<Integer, Integer> squareNumberCache;

    public CacheHelper() {
        cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder().build();
        cacheManager.init();

        squareNumberCache = cacheManager
                .createCache("squaredNumber", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                Integer.class, Integer.class,
                                ResourcePoolsBuilder.heap(10)));
    }

    public Cache<Integer, Integer> getSquareNumberCacheFromCacheManager() {
        return cacheManager.getCache("squaredNumber", Integer.class, Integer.class);
    }

    // standard getters and setters

}
