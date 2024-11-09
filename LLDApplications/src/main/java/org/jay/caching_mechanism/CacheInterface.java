package org.jay.caching_mechanism;

/**
 * Cache Interface will have all the required functions
 * required for caching Key Store's
 * Third party can give implementations
 * according to their usage
 * @param <KEY,VALUE></KEY,VALUE>
 */
public interface CacheInterface<KEY,VALUE> {

    /**
     * Will be used to add record to the cache
     * @param key
     * @param value
     */
    void addRecord(KEY key,VALUE value);

    /**
     * will be used to get the record from
     * the cache based on key
     * @param key
     * @return
     */
    VALUE getRecord(KEY key);

}
