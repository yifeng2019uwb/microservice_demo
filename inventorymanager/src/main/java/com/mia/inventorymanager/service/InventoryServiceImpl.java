package com.mia.inventorymanager.service;

import com.mia.inventorymanager.entity.Inventory;
import com.mia.inventorymanager.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository repository;

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public List<Inventory> saveInventories(List<Inventory> products) {
        return repository.saveAll(products);
    }

    @Override
    public List<Inventory> getInventories() {
        return repository.findAll();
    }

    @Override
    public Inventory getInventoryById(int id)  {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Inventory getInventoryByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public String deleteInventory(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        Inventory existingInventory = repository.findById(inventory.getId()).orElse(null);
        if (inventory.getName() != null) existingInventory.setName(inventory.getName());
        existingInventory.setAvailableQuantity(inventory.getAvailableQuantity());
        return repository.save(existingInventory);
    }

    @Override
    public Inventory updateInventoryQuantity(Inventory inventory, int count) {
        Inventory existingInventory = repository.findById(inventory.getId()).orElse(null);
        existingInventory.setAvailableQuantity(inventory.getAvailableQuantity() + count);
        return repository.save(existingInventory);
    }

}
