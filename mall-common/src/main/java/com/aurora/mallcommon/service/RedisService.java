package com.aurora.mallcommon.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * redis操作Service
 */
public interface RedisService {
    /**
     * 保存属性
     */
    void set(String key,Object value,long time);

    /**
     * 保存属性
     */
    void set(String key,Object value);

    /**
     * 获取属性
     */
    Object get(String key);

    /**
     * 删除属性
     */
    Boolean del(String key);

    /**
     * 删除属性
     * @param keys
     * @return
     */
    Long del(List<String> keys);

    /**
     * 设置过期时间
     * @param key
     * @param time
     * @return
     */
    Boolean expire(String key,long time);

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    Long getExpire(String key);

    /**
     * 判断是否有该属性
     * @param key
     * @return
     */
    Boolean hasKey(String key);

    /**
     * 按delta递增
     * @param key
     * @param delta
     * @return
     */
    Long incr(String key,long delta);

    /**
     * 按delta递减
     * @param key
     * @param delta
     * @return
     */
    Long decr(String key,long delta);
}
