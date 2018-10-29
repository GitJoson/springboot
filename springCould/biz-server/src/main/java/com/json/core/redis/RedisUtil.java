package com.json.core.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    // RedisTemplate，可以进行所有的操作
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, String value) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        boolean bExistent = this.stringRedisTemplate.hasKey(key);
        if (bExistent) {
            logger.info("this key is bExistent!");
        } else {
            ops.set(key, value);
        }
    }

    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        this.stringRedisTemplate.delete(key);
    }

    public void sentinelSet(String key, Object object) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(object));
    }

    public String sentinelGet(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }
}
