package com.labinventory.lab_inventory_system.service;

import com.labinventory.lab_inventory_system.model.InventoryItem;
import com.labinventory.lab_inventory_system.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    private InventoryCacheService inventoryCacheService;
    

    public Optional<InventoryItem> getInventorsyItemById(String id) {
        InventoryItem inventoryCachedItem = inventoryCacheService.getInventoryItemFromCache(id);
        if (inventoryCachedItem != null) {
            return Optional.of(inventoryCachedItem);
        }

        Optional<InventoryItem> inventoryItem = inventoryItemRepository.findById(id);
        inventoryItem.ifPresent(inventoryCacheService::addInventoryItemToCache);
        return inventoryItem;
       
    }

    //Métodos de Búsqueda y Ordenamiento
    public List<InventoryItem> searchInventoryItems(String keyword){
        List<InventoryItem> allInventoryItems = inventoryItemRepository.findAll();
        return allInventoryItems.stream()
                .filter(inventoryItem -> inventoryItem.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        inventoryItem.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<InventoryItem> sortInventoryItems(String sortBy){
        List<InventoryItem> allInventoryItems = inventoryItemRepository.findAll();
        switch (sortBy.toLowerCase()){
            case "name":
                return allInventoryItems.stream()
                        .sorted(Comparator.comparing(InventoryItem::getName))
                        .collect(Collectors.toList());
            case "quantity":
                return allInventoryItems.stream()
                        .sorted(Comparator.comparing(InventoryItem::getQuantity).reversed())
                        .collect(Collectors.toList());
            default:
                return allInventoryItems;
        }
    }

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
