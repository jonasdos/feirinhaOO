package com.feirinha.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinha.api.dtos.ItemDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.ItemRepository;
import com.feirinha.api.services.ItemService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/items")
public class ItemController {

  final ItemService itemService;
  ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @PostMapping()
  public ResponseEntity<Object> createItem(@RequestBody @Valid ItemDTO body) {
      Optional<ItemModel> verifyItem = itemService.verifyItemName(body.getName());
      if(verifyItem.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
      }
      ItemModel savedItem = itemService.saveItem(body);        
      return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
  }

  @GetMapping()
  public ResponseEntity<Object> getItems() {
      List<ItemModel> items = itemService.getAllItems();
      return ResponseEntity.status(HttpStatus.OK).body(items);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Object> getItem(@PathVariable("id") Long id) {
    Optional<ItemModel> item = itemService.getItemById(id);
    if(item.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(item);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
  @PutMapping("/{id}")
    public ResponseEntity<Object> putItem(@PathVariable("id") Long id, @RequestBody @Valid ItemDTO body) {

      if(!itemService.getItemById(id).isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      if(itemService.itemNameAndIdVerification(body.getName(), id).isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
      }
      ItemModel item = itemService.putItem(id, body);     
     
      return ResponseEntity.status(HttpStatus.OK).body(item);
    }


  }
   

