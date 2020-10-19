package com.mia.order.controller;


import com.mia.customer.entity.Customer;
import com.mia.order.entity.Order;
import com.mia.order.repository.OrderRepository;
import com.mia.order.service.OrderService;
import com.mia.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/order")
    public Order addProduct(@RequestBody Order order) {
        // validate the customer
//        "/customerById/{id}
        String url = "http://localhost:7010/customerById/"+order.getCustomer_id() ;
        Customer customer = restTemplate.getForObject(url, Customer.class);
        System.out.println(customer.getEmail());
        if (customer != null)  return orderService.saveOrder(order);
        return null;
    }

    @RequestMapping(value = "/products")
    public List<Product> getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <Product> entity = new HttpEntity<Product>(headers);
        String url = "http://localhost:9010/products";
//        return restTemplate.getForObject(" http://localhost:9010/products", HttpMethod.GET, entity, Product.class).getBody();

        return restTemplate.getForObject(url, List.class);

    }

}
