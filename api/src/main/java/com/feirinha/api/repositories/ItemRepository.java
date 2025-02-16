package com.feirinha.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feirinha.api.models.ItemModel;



@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {
  Optional<ItemModel> findByName(String name);
  Optional<ItemModel> findByNameAndIdNot(String name, Long id);
}
