package com.feirinha.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/items")
public class ItemController {

  @PostMapping()
  public ResponseEntity<Object> createItem(@RequestBody String entity) {
      
      
      return ResponseEntity.status(HttpStatus.CREATED).body(entity);
  }
  
}
