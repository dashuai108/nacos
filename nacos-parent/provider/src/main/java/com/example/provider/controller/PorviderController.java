package com.example.provider.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.provider.entity.Test;
import com.example.provider.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/provider")
@RefreshScope
public class PorviderController {

    @Autowired
    private TestService testService;

    @Value(value = "${provider:777}")
    public String uname;

    @RequestMapping("/get")
    public String get(){
        Test test = testService.getTest();
        List<Test> all = testService.getAll();
        return Arrays.toString(all.toArray());
    }
}


