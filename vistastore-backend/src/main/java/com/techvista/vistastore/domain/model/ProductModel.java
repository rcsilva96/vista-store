package com.techvista.vistastore.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

  private Long id;
  private String name;
  private String description;
  private String barCode;
  private int stock;
  private Double price;

}
