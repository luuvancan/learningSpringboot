// package com.springlearn.webapp.config;

// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.cache.concurrent.ConcurrentMapCache;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// import org.springframework.cache.CacheManager;
// import org.springframework.cache.support.SimpleCacheManager;



// @Configuration
// @EnableCaching
// public class CacheConfig {

//     @Bean
//     public CacheManager cacheManager() {
//         SimpleCacheManager cacheManager = new SimpleCacheManager();
//         cacheManager.setCaches(List.of(
//                 new ConcurrentMapCache("studentCache") // Định nghĩa cache tên "employeeCache"
//         ));
//         return cacheManager;
//     }
// }
