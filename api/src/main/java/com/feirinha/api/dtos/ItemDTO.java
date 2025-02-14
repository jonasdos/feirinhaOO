package com.feirinha.api.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemDTO {
  @NotBlank
  @Size(min = 3, max = 50)
  private String name;
  @Min(1)
  private int quantity;
  



}
