package com.example.workshopbff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired OrderClient orderClient;
    @Autowired ProductClient productClient;

    @GetMapping
    public List<Order> list(){
        return orderClient.list();
    }
    //    public List<Order> list(@RequestHeader(value = "X-ZUUL-USER") String user){
//        return orderClient.list();
//    }

    //no deep call chain
    @GetMapping
    public Order get(){
        Order order =  orderClient.get("1");
        order.product = productClient.get("1").name;
        return order;
    }

    //use call chain inside order
    @GetMapping("/foo/{id}")
    public Order foo(@PathVariable("id") String id){
        Order order =  orderClient.foo(id);
        return order;
    }

    @PostMapping
    public Order create(@RequestHeader(value = "X-ZUUL-USER") String user,@RequestBody Order request){
        request.user = user;
        return (Order)orderClient.create(request);
    }
}
