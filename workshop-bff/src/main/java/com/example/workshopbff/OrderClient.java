package com.example.workshopbff;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("order")
public interface OrderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    List<Order> list();

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    Order create(Order entity);

    @RequestMapping(method = RequestMethod.GET,value = "/orders/{id}")
    Order get(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET,value = "/foo/{id}")
    Order foo(@PathVariable("id") String id);
}

