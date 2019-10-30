package com.example.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@RefreshScope
public class ConsumerController {

    //服务名称
    @Value(value = "${provider.name:test}")
    private static String SERVICE_NAME ;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        System.out.println("SERVICE_NAME:"+SERVICE_NAME);
        return discoveryClient.getInstances(SERVICE_NAME);
    }

    /**
     * 消费服务
     */
    @RequestMapping("/get")
//    public String services(@RequestParam("name") String name) {
    public String getService() {

        ServiceInstance serviceInstance = (ServiceInstance) discoveryClient.getInstances(SERVICE_NAME).get(0);

        System.out.println(serviceInstance.getUri().toString() +"/"+serviceInstance.getServiceId()+ "/get");
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() +"/"+serviceInstance.getServiceId()+ "/get", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }


}
