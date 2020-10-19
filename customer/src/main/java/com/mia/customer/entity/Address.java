package com.mia.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;

    //    @Column(name="addressline")
//    private String addressLine;
    private String addressLine1;
    private String addressLine2;

    private String city;

    private String state;

    private String country;

    //    @Column(name="zip")
    private String zipCode;
}
