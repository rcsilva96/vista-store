package com.techvista.vistastore.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemSellDTO {

  @JsonProperty("productId")
  private Long productId;
  private Integer quantity;
  
}
