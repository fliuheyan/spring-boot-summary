package com.cloud.redis.helper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Data
public class RedisTemplateWrapper<T> {
    @Resource
    private LettuceConnectionFactory redisConnectionFactory;

    private final RedisTemplate<String, T> redisTemplate;

    @Bean
    public RedisTemplateWrapper<T> get() {
        return new RedisTemplateWrapper<T>();
    }

    public RedisTemplateWrapper() {
        System.out.println("#########init redis template wrapper");
        redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        System.out.println("###########" + redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
    }
}
