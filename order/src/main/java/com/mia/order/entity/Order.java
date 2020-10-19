package com.mia.order.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import com.mia.product.entity.Product;
import com.mia.customer.entity.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="ORDER1_TABLE")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int customer_id;

    //    private List<Product> itemList;
//   private LinkedHashMap<int, int> itemList;
    private int quantity;
    private double totalPrice;
    private OrderStatus status ;

}
