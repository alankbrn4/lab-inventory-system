package com.labinventory.lab_inventory_system.repository;

import com.labinventory.lab_inventory_system.model.InventoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryItemRepository extends MongoRepository<InventoryItem, String> {
}
