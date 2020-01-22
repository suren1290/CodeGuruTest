package org.blacksun.pediredla;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Pediredla on 1/13/17.
 */
public class LRUCache {
    private Map<String, Integer> cache;

    public LRUCache(int cap) {
        cache = new LinkedCappedHashMap<String, Integer>(cap);
    }

    public int get(String key) {
        if(!cache.containsKey(key)) return -1;
        return cache.get(key);
    }

    public void set(String key, int val) {
        cache.put(key, val);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int capacity;
        LinkedCappedHashMap(int cap) {
            super(16, 0.75f, true);
            this.capacity = cap;
        }
        protected boolean removeEldestEntry(Map.Entry oldest) {
            return size() > capacity;
        }
    }
}
