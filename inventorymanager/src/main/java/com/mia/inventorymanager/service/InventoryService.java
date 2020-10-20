package com.mia.inventorymanager.service;

import com.mia.inventorymanager.entity.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory saveInventory(Inventory inventory);
    List<Inventory> saveInventories(List<Inventory> inventories);
    List<Inventory> getInventories();
    Inventory getInventoryById(int id);
    Inventory getInventoryByName(String name);
    String deleteInventory(int id);
    Inventory updateInventory(Inventory inventory);
    Inventory updateInventoryQuantity(Inventory inventory, int count);

}
