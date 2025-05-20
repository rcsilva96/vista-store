package com.techvista.vistastore.application.controller;

import com.techvista.vistastore.application.dto.SellRequestDTO;
import com.techvista.vistastore.application.dto.SellByBarcodeRequestDTO;
import com.techvista.vistastore.application.dto.SellResponseDTO;
import com.techvista.vistastore.application.service.SellService;
import com.techvista.vistastore.domain.model.SellModel;
import com.techvista.vistastore.domain.model.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/sells")
@RequiredArgsConstructor
public class SellController {

  private final SellService sellService;

  @PostMapping
  public ResponseEntity<SellModel> newSell(@RequestBody SellRequestDTO sellRequestDTO){

    //todo: remover isso depois

    System.out.println("DTO recebido: " + sellRequestDTO);
    System.out.println("Itens: " + sellRequestDTO.getItens());

    if (sellRequestDTO.getItens() != null && !sellRequestDTO.getItens().isEmpty()) {
      System.out.println("Primeiro item - productId: " +
          sellRequestDTO.getItens().get(0).getProductId());
    }

    //todo: remover isso depois

    SellModel sell = sellService.newSell(sellRequestDTO);
    return ResponseEntity.ok(sell);

  }

  @PostMapping("/sell-by-barcode")
  public ResponseEntity<SellResponseDTO> newSellBarcode(@RequestBody SellByBarcodeRequestDTO request) {
      SellModel sell = sellService.newSellByBarCode(request.codes());
      String message = formatSellMessage(sell);
      return ResponseEntity.ok(new SellResponseDTO(message, sell));
  }

  private String formatSellMessage(SellModel sell) {
    StringBuilder message = new StringBuilder();
    Map<ProductModel, Integer> quantityByProduct = new HashMap<>();
    BigDecimal totalVenda = BigDecimal.ZERO;

    // Agrupa produtos e suas quantidades
//    sell.getItens().forEach(item -> {
//      quantityByProduct.merge(item.getProduct(), 1, Integer::sum);
//    });
    sell.getItens().forEach(item -> {
      quantityByProduct.merge(
          item.getProduct(),
          item.getQuantity(), // Usa a quantidade do item em vez de 1
          Integer::sum
      );
    });


    // Formata a mensagem
    quantityByProduct.forEach((product, quantity) -> {
      BigDecimal precoUnitario = BigDecimal.valueOf(product.getPrice());
      BigDecimal total = precoUnitario.multiply(BigDecimal.valueOf(quantity));
      totalVenda.add(total);

      message.append(String.format(
          "Você vendeu %d unidade(s) de %s a R$ %.2f cada, totalizando R$ %.2f. ",
          quantity,
          product.getName(),
          product.getPrice(),
          total
      ));
    });

    message.append(String.format("O total da sua venda foi R$ %.2f.", sell.getValorTotal()));

    return message.toString();
  }

}
