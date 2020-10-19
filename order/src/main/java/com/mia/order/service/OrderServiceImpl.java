package com.mia.order.service;


import com.mia.order.entity.Order;
import com.mia.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order saveOrder(Order order) {

        return orderRepository.save(order);

    }

    @Override
    public List<Order> saveOrders(List<Order> orderList) {
        return orderRepository.saveAll(orderList);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

}
