package com.cloud.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.joda.money.Money;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Application {
    private int id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
