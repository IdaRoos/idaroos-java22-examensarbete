package com.idaroos.theglobalnewsarchive.cache;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.benmanes.caffeine.cache.Cache;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "caffeineCacheStats")
public class CaffeineCacheStatsEndpoint {

    @Autowired
    private CacheManager cacheManager;

    @ReadOperation
    public Map<String, Object> getAllCacheStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("articleCache", getCacheStats("articleCache"));
        return stats;
    }

    private String getCacheStats(String cacheName) {
        CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(cacheName);
        if (caffeineCache != null) {
            Cache<Object, Object> nativeCache = caffeineCache.getNativeCache();
            return nativeCache.stats().toString();
        }
        return "Cache '" + cacheName + "' not found";
    }
}
