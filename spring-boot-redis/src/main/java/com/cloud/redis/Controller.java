package com.cloud.redis;

import com.cloud.redis.modal.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = new User(1l, "haha", "test@test.com");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
}
