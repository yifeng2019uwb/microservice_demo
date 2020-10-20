package com.mia.order.controller;


import com.mia.customer.entity.Customer;
import com.mia.order.entity.Order;
import com.mia.order.entity.OrderItem;
import com.mia.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/api/order")
    public Order addOrder(@RequestBody Order order) {
        // validate the customer
//        "/customerById/{id}
        // need update the product repository too
        String url = "http://localhost:7010/customerById/"+order.getCustomer_id() ;
        Customer customer = restTemplate.getForObject(url, Customer.class);
        System.out.println(customer.getEmail());
        if (customer != null)  return orderService.saveOrder(order);
        return null;
    }

    @RequestMapping(value = "/api/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/api/orders")
    public List<Order> getOrderList() {

         return orderService.getOrders();

    }

    @RequestMapping(value = "/api/orders/itemlist/{id}")
    public List<OrderItem> getOrderItemList(@PathVariable int id) {

        return orderService.getOrderById(id).getItems();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <Product> entity = new HttpEntity<Product>(headers);
//        String url = "http://localhost:9010/products";
////        return restTemplate.getForObject(" http://localhost:9010/products", HttpMethod.GET, entity, Product.class).getBody();

//        return restTemplate.getForObject(url, List.class);

//        return orderService.getOrders();

    }

}
