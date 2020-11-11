package com.cloud.redis.todolist.modal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {
    private String id;
    private String title;
    private String link;
    private String poster;
    private int like;
    private int unlike;
}
