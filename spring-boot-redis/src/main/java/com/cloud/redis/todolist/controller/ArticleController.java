package com.cloud.redis.todolist.controller;

import com.cloud.redis.helper.RedisTemplateWrapper;
import com.cloud.redis.todolist.modal.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private static final String SCHEMA = "forum";
    public static final String ARTICLE = "article";
    private final RedisTemplate<String, Article> redisTemplate;
//    private final RedisTemplateWrapper<Article> redisTemplateWrapper;

//    public ArticleController(RedisTemplateWrapper<Article> redisTemplateWrapper) {
//        this.redisTemplateWrapper = redisTemplateWrapper;
//    }
//
//    public ArticleController(RedisTemplateWrapper<Article> redisTemplateWrapper) {
//        this.redisTemplateWrapper = redisTemplateWrapper;
//    }

    public ArticleController(@Qualifier("redisTemplateWrapper") RedisTemplate<String, Article> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping
    public void saveArticle(@RequestBody Article article) {

        redisTemplate.opsForValue().set(generateKey(article.getId()), article);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return null;
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable String id) {
        return redisTemplate.opsForValue().get(generateKey(id));
    }

    @PostMapping("/voting/like/{id}")
    public void likeTopic(@PathVariable String id) {

    }

    @PostMapping("/voting/unlike/{id}")
    public void unlikeTopic(@PathVariable String id) {

    }

    private String generateKey(String tableName, String id) {
        return SCHEMA + ":" + tableName + ":" + id;
    }

    private String generateKey(String id) {
        return generateKey(ARTICLE, id);
    }
}
