package com.guiyunweb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author wnkj
 */
@Repository
public class RedisUtils {

    private static final Long TIME = 30L;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add(String key, Object obj) {
        stringRedisTemplate.opsForValue().set(key, JsonUtils.toJSONString(obj), TIME, TimeUnit.MINUTES);
    }

    public void add(String key, Object obj, Long time) {
        stringRedisTemplate.opsForValue().set(key, JsonUtils.toJSONString(obj), time, TimeUnit.MINUTES);
    }


    public String getString(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return source;
        }
        return null;
    }

    public <T> T get(String key, Class<T> tClass) {
        String string = getString(key);
        if (!StringUtils.isEmpty(string)) {
            return JsonUtils.parse(string, tClass);
        } else {
            return null;
        }
    }

    public void delete(String key) {
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
}
