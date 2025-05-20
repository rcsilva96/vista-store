package com.techvista.vistastore.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

  private Long id;

  @JsonProperty("bar_code")
  private String barCode;

  private String name;

  private String description;

  private int stock;

  private Double price;

}
