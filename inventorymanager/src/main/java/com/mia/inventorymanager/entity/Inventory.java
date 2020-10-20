package com.mia.inventorymanager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "INVENTORY")
public class Inventory  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode; // barcode?

    private String name;

    @Column(name = "quantity")
    private Integer availableQuantity = 0;

    private String desciption;

//    private string barcode;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inventory other = (Inventory)obj;
        if (id != other.getId())
            return false;
        return true;

    }
}
