package com.techvista.vistastore.application.controller;

import com.techvista.vistastore.application.dto.SellRequestDTO;
import com.techvista.vistastore.application.service.SellService;
import com.techvista.vistastore.domain.model.SellModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
