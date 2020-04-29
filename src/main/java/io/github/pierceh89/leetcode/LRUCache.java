package io.github.pierceh89.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Leetcoding Challenge Week4 Day3
 */
public class LRUCache {
    int cap;
    Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
    }

    public int get(int key) {
        int result = -1;

        if(cache.containsKey(key)){
            result = cache.get(key);
            cache.remove(key);
            cache.put(key, result);
        }

        return result;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if(cache.size() == cap) {
                int first = cache.keySet().iterator().next();
                cache.remove(first);
            }
        }
        cache.put(key, value);
    }
}

