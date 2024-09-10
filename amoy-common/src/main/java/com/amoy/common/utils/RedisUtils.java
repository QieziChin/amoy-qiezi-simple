package com.amoy.common.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 */
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**  默认过期时长为24小时，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24L;
    /**  过期时长为1小时，单位：秒 */
    public final static long HOUR_ONE_EXPIRE = 60 * 60 * 1L;
    /**  过期时长为6小时，单位：秒 */
    public final static long HOUR_SIX_EXPIRE = 60 * 60 * 6L;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1L;


    //String类型
    //redisTemplate.opsForValue();
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public void set(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void set(String key, String value, long timeout, TimeUnit unit){
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public String get(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
    //Hash类型
    // redisTemplate.opsForHash();
    public void hSet(String key, String hashKey, Object value){
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * Redis 模拟Hash field 过期
     * 适用于用户登录
     * 单独维护一个摘要的key 过期时间，然后每隔1小时去删除对应field字段
     * supper key 需要手动添加
     */
    public void hSet(String key, String hashKey, Object value, long timeout){
        String ttlKey = Digest.MD5.getHash(key + hashKey);
        redisTemplate.opsForHash().put(key, hashKey, value);
        expire(ttlKey, timeout);
    }

    public void hSet(String key, String hashKey, Object value, long timeout, TimeUnit unit){
        String ttlKey = Digest.MD5.getHash(key + hashKey);
        redisTemplate.opsForHash().put(key, hashKey, value);
        set(ttlKey, null);
        expire(ttlKey, timeout, unit);
    }

    public Boolean hasKey(String key, String hashKey){
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }


    public Object hGet(String key, String hashKey){
        return redisTemplate.opsForHash().get(key, hashKey);
    }
    /**
     * 获取hash 表中所有 keys 的集合
     * @param key
     * @return
     */
    public Set<Object> hKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }
    /**
     * 获取所有 Values
     * @param key
     * @return
     */
    public List<Object> hVals(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    public Object delete(String key, String hashKey){
        return redisTemplate.opsForHash().delete(key, hashKey);
    }
 //List类型
// redisTemplate.opsForList();

//Set类型
// redisTemplate.opsForSet();

//ZSet类型
// redisTemplate.opsForZSet();
    public void expire(String key) {
        redisTemplate.expire(key, 24, TimeUnit.HOURS);
    }

    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    public void hMSet(String key, Map<String, Object> map) {
        hMSet(key, map, DEFAULT_EXPIRE);
    }

    public void hMSet(String key, Map<String, Object> map, long expire) {
        redisTemplate.opsForHash().putAll(key, map);

        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    public void hDel(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    public void leftPush(String key, Object value) {
        leftPush(key, value, DEFAULT_EXPIRE);
    }

    public void leftPush(String key, Object value, long expire) {
        redisTemplate.opsForList().leftPush(key, value);

        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }
}
