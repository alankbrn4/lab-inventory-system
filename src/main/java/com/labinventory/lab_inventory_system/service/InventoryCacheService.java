package com.labinventory.lab_inventory_system.service;

import com.labinventory.lab_inventory_system.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InventoryCacheService {

    private final ConcurrentHashMap<String, InventoryItem> inventoryCache = new ConcurrentHashMap<>();

    public void addInventoryItemToCache(InventoryItem inventoryItem) {
        inventoryCache.put(inventoryItem.getId(), inventoryItem);
    }

    public InventoryItem getInventoryItemFromCache(String id) {
        return inventoryCache.get(id);
    }

    public void updateInventoryItemInCache(InventoryItem inventoryItem) {
        inventoryCache.put(inventoryItem.getId(), inventoryItem);
    }

    public void deleteInventoryItemFromCache(String id) {
        inventoryCache.remove(id);
    }

}
