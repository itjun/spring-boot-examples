package io.itjun.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RedisController {

    public static long staticCount = 0;
    public long invoiceCount = 0;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! staticCount = " + String.valueOf(++staticCount)
                + " , invoiceCount= " + String.valueOf(++invoiceCount);
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    // wrk -t1 -c1 -d1s http://127.0.0.1:8080/redis/incr
    @PostMapping("incr")
    public Long incr() {
        long value = redisTemplate.opsForValue().increment("911001.OC.2021-01-30");
        return value;
    }

    @PostMapping("set")
    public String set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }

    @PostMapping("setex")
    public String setex(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        return key + "," + value + "," + timeout;
    }

    @PostMapping("get")
    public String get(String key) {
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }

    @PostMapping("delete")
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @PostMapping("keys")
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    @PostMapping("lpush")
    public Long lPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    @PostMapping("rpop")
    public String rPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    @PostMapping("ttl")
    public Long ttl(String key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.ttl(key.getBytes()));
    }

    @RequestMapping("pipeline")
    public Long pipeline() {
        long start = System.currentTimeMillis();
        redisTemplate.executePipelined((RedisCallback<List>) connection -> {
            for (int i = 0; i < 100000; i++) {
                String key = "pipeline_" + i;
                String value = "value" + i;
                connection.set(key.getBytes(), value.getBytes());
                connection.get(key.getBytes());
            }
            return null;
        });

        return System.currentTimeMillis() - start;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args) {
        System.out.println(randInt(5, 10));
    }
}