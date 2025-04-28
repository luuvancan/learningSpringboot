package com.springlearn.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.webapp.service.CacheService;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@RestController
@RequestMapping("/api/cache")
@Data
@AllArgsConstructor
public class CacheController {
    private final CacheService cacheService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, String>> getAllCache() { // Thay đổi kiểu trả về
        Map<String, String> cacheData = cacheService.getAllCacheData();
        return ResponseEntity.ok(cacheData); // Spring sẽ tự động convert Map<String, String> sang JSON
    }
}