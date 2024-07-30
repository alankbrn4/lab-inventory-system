package com.labinventory.lab_inventory_system.service;

import com.labinventory.lab_inventory_system.model.InventoryItem;
import com.labinventory.lab_inventory_system.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    private InventoryCacheService inventoryCacheService;
    

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    public InventoryItem getInventoryItemById(String id) {
        return inventoryItemRepository.findById(id).orElse(null);
    }

    public InventoryItem addInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    public InventoryItem updateInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    public void deleteInventoryItem(String id) {
        inventoryItemRepository.deleteById(id);
    }   



}
