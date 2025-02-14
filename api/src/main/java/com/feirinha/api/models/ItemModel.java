package com.feirinha.api.models;

import com.feirinha.api.dtos.ItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters e setters
@AllArgsConstructor // cria um construtor com todos os argumentos da classe
@NoArgsConstructor // cria um construtor sem argumentos(propriedades nulas)
@Entity // transforma o Model em uma tabela no banco de dados
@Table(name = "tb-items") // nomeia a tabela no banco de dados
public class ItemModel {
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length = 150, nullable = false)
  private String name;
  @Column(length = 150, nullable = false)
  private int quantity; 

  public ItemModel(ItemDTO dto) {
    this.name = dto.getName();
    this.quantity = dto.getQuantity();
  }
}
