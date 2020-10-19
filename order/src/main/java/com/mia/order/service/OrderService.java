package com.mia.order.service;

import com.mia.order.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> saveOrders(List<Order> orderList);
    List<Order> getOrders();
    Order getOrderById(int id);
//    List<Order> getOrdersByCustomer(Customer customer);


}
