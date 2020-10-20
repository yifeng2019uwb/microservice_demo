package com.mia.inventorymanager.controller;

import com.mia.inventorymanager.entity.Inventory;
import com.mia.inventorymanager.service.InventoryService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService service;

    @PostMapping("/api/inventory")
    public Inventory addProduct(@RequestBody Inventory product) {
        return service.saveInventory(product);
    }

    @PostMapping("/api/inventories")
    public List<Inventory> addProducts(@RequestBody List<Inventory> products) {
        return service.saveInventories(products);
    }

    @GetMapping("/api/inventories")
    public List<Inventory> findAllProducts() {
        return service.getInventories();
    }

    @GetMapping("/inventoryById/{id}")
    public Inventory findInventoryById(@PathVariable int id) {
        return service.getInventoryById(id);
    }

    @GetMapping("/inventory/{name}")
    public Inventory findInventoryByName(@PathVariable String name) {
        return service.getInventoryByName(name);
    }

    @PutMapping("/update")
    public Inventory updateProduct(@RequestBody Inventory product) {
        return service.updateInventory(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteInventory(id);
    }

    @PutMapping("/updateQuantity")
    public Inventory updateProdcutQuantity(@RequestBody Inventory product, @NonNull int quantity) {
        return updateProdcutQuantity(product, product.getAvailableQuantity());
    }

}
