package com.feirinha.api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.ItemRepository;

@Service
public class ItemService {
  final ItemRepository itemRepository;
  ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
}
  public Optional<ItemModel> verifyItemService(String name) {
     return itemRepository.findByName(name);
    
  } 
  public ItemModel saveItemService(ItemDTO body) {
  ItemModel item = new ItemModel(body);
  return itemRepository.save(item);
}
}
