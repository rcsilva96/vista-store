package com.techvista.vistastore.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SellRequestDTO {

  private List<ItemSellDTO> itens;

}

