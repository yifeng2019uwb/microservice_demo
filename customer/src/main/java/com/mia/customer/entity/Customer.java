package com.mia.customer.entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="customer3")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private String email;

    //    @Embedded
//    @AttributeOverrides(value = { @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
//            @AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

}
