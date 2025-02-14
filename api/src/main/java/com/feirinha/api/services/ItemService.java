package com.feirinha.api.services;

import java.util.List;
import java.util.Optional;

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
  public Optional<ItemModel> verifyItemName(String name) {
     return itemRepository.findByName(name);
    
  } 
  public ItemModel saveItem(ItemDTO body) {
  ItemModel item = new ItemModel(body);
  return itemRepository.save(item);
}

public List<ItemModel> getAllItems() {
  return itemRepository.findAll();
}
public Optional<ItemModel> getItemById(Long id) {
  return itemRepository.findById(id);
}
public Optional<ItemModel> itemNameAndIdVerification(String name, Long id) {
  return itemRepository.findByNameAndIdNot(name, id);
}
public Optional<ItemModel> updateItem(Long id, ItemDTO body) {
  Optional<ItemModel> item = itemRepository.findById(id);

  if(!item.isPresent()) {
    return Optional.empty();
  }
  ItemModel edit = item.get();
  edit.setName(body.getName());
  edit.setQuantity(body.getQuantity());
  itemRepository.save(edit);
  
  return Optional.of(edit);
}
public void deleteItem(Long id) {
  itemRepository.deleteById(id);

}
}
