package org.jay.caching_mechanism;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Implemention of methods for adding
 * and fetching mechanism of cache
 * @param <KEY>
 * @param <VALUE>
 */
public class Jcache<KEY,VALUE>  implements CacheInterface<KEY,VALUE>{
    int capacity;
    final int initialCapacity = 16;
    final float loadfactor = 0.75f;

    final Integer recordNotFoundValue = -1;
    Map<KEY,VALUE> lru;

    /**initializing the Least Recently Used map
      * 16 is the initial capacity
      * 0.75 is the load factor
      * @Overriding removeEldestEntry so that when lruMap reaches the capacity
      * it will remove the least used element
     */

    public Jcache(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        lru =  Collections.synchronizedMap(new LinkedHashMap<>(
                        initialCapacity,loadfactor,
                        true){
            @Override
            public boolean removeEldestEntry(Map.Entry<KEY,VALUE> lru) {
                return size() > capacity;
            }
        });
    }

    /**
     * Will add record to LRU Map
     * @param key
     * @param value
     */
    @Override
    public void addRecord(KEY key, VALUE value) {
       lru.put(key,value);
    }

    /**
     * Will fetch element from Map
     * based on key
     * @param key
     * @return
     */
    @Override
    public VALUE getRecord(KEY key) {
        return lru.getOrDefault(key, (VALUE) recordNotFoundValue);
    }

}
