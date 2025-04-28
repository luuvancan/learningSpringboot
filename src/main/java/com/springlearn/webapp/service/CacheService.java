package com.springlearn.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Data
@AllArgsConstructor
public class CacheService {
    private final RedisTemplate<String, String> redisTemplateString;

    public Map<String, String> getAllCacheData() {
        Set<String> keys = redisTemplateString.keys("*");
        Map<String, String> cacheData = new HashMap<>();

        if (keys != null && !keys.isEmpty()) {
            for (String key : keys) {
                String value = redisTemplateString.opsForValue().get(key);
                if (value != null) {
                    cacheData.put(key, value);
                }
            }
        }
        return cacheData;
    }
}