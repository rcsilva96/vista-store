package com.techvista.vistastore.domain.model;

import com.techvista.vistastore.infra.entity.ProductEntity;
import com.techvista.vistastore.infra.entity.SellEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemSellModel {
  private Long id;
  private ProductModel product; // Mudança aqui: usar ProductModel
  private int quantity;
  private BigDecimal unitPrice;
  private SellModel venda; // Mudança aqui: usar SellModel
}
