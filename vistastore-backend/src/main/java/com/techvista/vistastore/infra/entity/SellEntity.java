package com.techvista.vistastore.infra.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "vendas")
@Getter
@Setter
public class SellEntity {

  @Id
  @GeneratedValue
  private Long id;

  private BigDecimal valorTotal;

  @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
  private List<ItemSellEntity> itens;

}
