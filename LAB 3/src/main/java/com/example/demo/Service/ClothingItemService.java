package com.example.demo.Service;

import com.example.demo.Model.ClothingItem;
import com.example.demo.Repository.ClothingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingItemService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    public ClothingItem createClothingItem(ClothingItem clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    public List<ClothingItem> getAllClothingItems() {
        return clothingItemRepository.findAll();
    }

    public ClothingItem getClothingItemById(Long id) {
        return clothingItemRepository.findById(id).orElse(null);
    }

    public ClothingItem updateClothingItem(Long id, ClothingItem clothingItem) {
        if (clothingItemRepository.existsById(id)) {
            clothingItem.setId(id);
            return clothingItemRepository.save(clothingItem);
        }
        return null;
    }

    public void deleteClothingItem(Long id) {
        clothingItemRepository.deleteById(id);
    }
}
