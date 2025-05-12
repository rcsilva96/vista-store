package com.techvista.vistastore.domain.repository;

import com.techvista.vistastore.domain.model.SellModel;

public interface SellRepository {

  SellModel saveSell(SellModel sellModel);
  SellModel findSellById(Long id);

}
