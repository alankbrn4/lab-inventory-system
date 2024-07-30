package com.labinventory.lab_inventory_system.controller;

import com.labinventory.lab_inventory_system.model.InventoryItem;
import com.labinventory.lab_inventory_system.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventory", description = "API for managing lab inventory items")
public class InventoryController {
    
    @Autowired
    public InventoryService inventoryService;

    @GetMapping
    @Operation(summary = "Get all inventory items", description = "Get all inventory items from the database")
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get inventory item by ID", description = "Get inventory item from the database by ID")
    public InventoryItem getInventoryItemById(@PathVariable String id) {
        return inventoryService.getInventoryItemById(id);
    }

    @PostMapping
    @Operation(summary = "Add inventory item", description = "Add inventory item to the database")
    public InventoryItem addInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.addInventoryItem(inventoryItem);
    }

    @PutMapping
    @Operation(summary = "Update inventory item", description = "Update inventory item in the database")
    public InventoryItem updateInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.updateInventoryItem(inventoryItem);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete inventory item", description = "Delete inventory item from the database")
    public void deleteInventoryItem(@PathVariable String id) {
        inventoryService.deleteInventoryItem(id);
    }



}
