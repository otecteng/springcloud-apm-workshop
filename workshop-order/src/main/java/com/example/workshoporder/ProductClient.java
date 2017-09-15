package com.example.workshoporder;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("product")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> list();

    @RequestMapping(method = RequestMethod.GET,value = "/products/{id}")
    Product get(@PathVariable("id") String id);
}