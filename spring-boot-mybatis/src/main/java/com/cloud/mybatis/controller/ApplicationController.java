package com.cloud.mybatis.controller;

import com.cloud.mybatis.mapper.ApplicationMapper;
import com.cloud.mybatis.model.Application;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private ApplicationMapper mapper;

    public ApplicationController(ApplicationMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getApplications() {

        mapper.save(Application.builder().id(atomicInteger.getAndIncrement())
                .name("test")
                .createTime(new Date())
                .price(Money.of(CurrencyUnit.of("CNY"), 100.0))
                .build());
        List<Application> list = mapper.findAll();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }
}
