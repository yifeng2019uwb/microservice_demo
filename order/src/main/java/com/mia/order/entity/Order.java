package com.mia.order.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ORDER1_TABLE")
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int customer_id;

//    private List<Product> itemList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
    private int quantity;
    private double totalPrice;
    private OrderStatus status ;

}
