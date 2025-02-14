package com.feirinha.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.ItemRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/items")
public class ItemController {
  final ItemRepository itemRepository;
  ItemController(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @PostMapping()
  public ResponseEntity<Object> createItem(@RequestBody @Valid ItemDTO body) {
      Optional<ItemModel> verifyItem = itemRepository.findByName(body.getName());
      if(verifyItem.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
      }
      ItemModel item = new ItemModel(body);
      ItemModel savedItem = itemRepository.save(item);
           
      
      return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
  }
  @GetMapping()
  public ResponseEntity<Object> getItems() {
      List<ItemModel> items = itemRepository.findAll();

      return ResponseEntity.status(HttpStatus.OK).body(items);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Object> getItemById(@PathVariable("id") Long id) {

      return ResponseEntity.status(HttpStatus.OK).build();
  }
  
  

  
}
