package io.itjun.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }

    @GetMapping("setex/{key}/{value}/{timeout}")
    public String setex(@PathVariable("key") String key, @PathVariable("value") String value,
                        @PathVariable("timeout") long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        return key + "," + value + "," + timeout;
    }

    @GetMapping("get/{key}")
    public String get(@PathVariable("key") String key) {
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }

    @GetMapping("delete/{key}")
    public Boolean delete(@PathVariable("key") String key) {
        return redisTemplate.delete(key);
    }

    @GetMapping("keys/{pattern}")
    public Set<String> list(@PathVariable("pattern") String pattern) {
        return redisTemplate.keys(pattern);
    }

    @GetMapping("lpush/{key}/{value}")
    public Long lPush(@PathVariable("key") String key, @PathVariable("value") String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    @GetMapping("rpop/{key}")
    public String rPop(@PathVariable("key") String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    @GetMapping("ttl/{key}")
    public Long ttl(@PathVariable("key") String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) {
                return connection.ttl(key.getBytes());
            }
        });
    }

}