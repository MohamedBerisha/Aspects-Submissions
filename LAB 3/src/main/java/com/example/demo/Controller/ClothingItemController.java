package com.example.demo.Controller;

import com.example.demo.Model.ClothingItem;
import com.example.demo.Service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clothing-items")
public class ClothingItemController {

    @Autowired
    private ClothingItemService clothingItemService;

    // Create new ClothingItem
    @PostMapping
    public ResponseEntity<ClothingItem> createClothingItem(@Valid @RequestBody ClothingItem clothingItem) {
        return new ResponseEntity<>(clothingItemService.createClothingItem(clothingItem), HttpStatus.CREATED);
    }

    // Get all ClothingItems
    @GetMapping
    public List<ClothingItem> getAllClothingItems() {
        return clothingItemService.getAllClothingItems(); // Fix: Call via instance, not statically
    }

    // Get a specific ClothingItem by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> getClothingItemById(@PathVariable Long id) {
        ClothingItem clothingItem = clothingItemService.getClothingItemById(id); // Fix: Call via instance
        if (clothingItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clothingItem);
    }

    // Update ClothingItem
    @PutMapping("/{id}")
    public ResponseEntity<ClothingItem> updateClothingItem(@PathVariable Long id, @RequestBody ClothingItem clothingItem) {
        ClothingItem updatedClothingItem = clothingItemService.updateClothingItem(id, clothingItem);
        if (updatedClothingItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedClothingItem);
    }

    // Delete ClothingItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable Long id) {
        clothingItemService.deleteClothingItem(id);
        return ResponseEntity.noContent().build();
    }
}
