package io.itjun.redis.controller;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String set(@PathVariable("key") String key, @PathVariable("value") String value,
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

}