package com.techvista.vistastore.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_vendidos")
@Getter
@Setter
public class ItemSellEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private ProductEntity product;

  private int quantity;

  private BigDecimal unitPrice;

  @ManyToOne
  private SellEntity venda;

}
