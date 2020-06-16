package com.guiyunweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author wnkj
 */
@Repository
public class RedisUtils {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    private static Long TIME = 30L;

    public void add(String key, Object obj) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(obj), TIME, TimeUnit.MINUTES);
    }

    public void add(String key, Object obj,Long time) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(obj), time, TimeUnit.MINUTES);
    }

    public JSONObject getJson(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return JSONObject.parseObject(source);
        }
        return null;
    }

    public String get(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return source;
        }
        return null;
    }

    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
}
