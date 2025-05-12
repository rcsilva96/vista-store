package com.techvista.vistastore.application.service;

import com.techvista.vistastore.application.dto.ItemSellDTO;
import com.techvista.vistastore.application.dto.SellRequestDTO;

import com.techvista.vistastore.domain.model.ItemSellModel;
import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.model.SellModel;

import com.techvista.vistastore.domain.repository.ProductRepository;
import com.techvista.vistastore.domain.repository.SellRepository;

import com.techvista.vistastore.infra.mapper.ProductMapper;
import com.techvista.vistastore.infra.mapper.SellMapper;
import com.techvista.vistastore.infra.mapper.ItemSellMapper;

import com.techvista.vistastore.infra.entity.ItemSellEntity;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SellService {
  private final ProductRepository productRepository;
  private final SellRepository sellRepository;
  private final ProductMapper productMapper;
  private final ItemSellMapper itemSellMapper;

  public SellService(ProductRepository productRepository,
                     SellRepository sellRepository,
                     ProductMapper productMapper,
                     ItemSellMapper itemSellMapper) {
    this.productRepository = productRepository;
    this.sellRepository = sellRepository;
    this.productMapper = productMapper;
    this.itemSellMapper = itemSellMapper;
  }

  public SellModel newSell(SellRequestDTO sellRequest) {
    List<ItemSellModel> itens = new ArrayList<>();
    BigDecimal total = BigDecimal.ZERO;

    for (ItemSellDTO itemDTO : sellRequest.getItens()) {
      ProductModel product = productRepository.findProductById(itemDTO.getProductId())
          .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

      if (product.getStock() < itemDTO.getQuantity()) {
        throw new RuntimeException("Estoque insuficiente");
      }

      product.setStock(product.getStock() - itemDTO.getQuantity());
      productRepository.saveProduct(product);

      BigDecimal unitPrice = BigDecimal.valueOf(product.getPrice());
      BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(itemDTO.getQuantity()));
      total = total.add(subtotal);

      ItemSellModel itemModel = new ItemSellModel();
      itemModel.setProduct(product);
      itemModel.setQuantity(itemDTO.getQuantity());
      itemModel.setUnitPrice(unitPrice);
      itens.add(itemModel);
    }

    SellModel sellModel = new SellModel();
    sellModel.setValorTotal(total);
    sellModel.setItens(itens);

    return sellRepository.saveSell(sellModel);
  }
}