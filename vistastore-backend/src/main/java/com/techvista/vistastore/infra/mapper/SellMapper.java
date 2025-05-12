package com.techvista.vistastore.infra.mapper;

import com.techvista.vistastore.domain.model.SellModel;
import com.techvista.vistastore.infra.entity.SellEntity;
import org.springframework.stereotype.Component;

@Component
public class SellMapper extends BaseMapper<SellEntity, SellModel> {
  private final ItemSellMapper itemSellMapper;

  public SellMapper(ItemSellMapper itemSellMapper) {
    this.itemSellMapper = itemSellMapper;
  }

  @Override
  public SellEntity toEntity(SellModel model) {
    if (model == null) return null;
    SellEntity entity = new SellEntity();
    entity.setId(model.getId());
    entity.setValorTotal(model.getValorTotal());
    entity.setItens(itemSellMapper.toEntity(model.getItens()));
    return entity;
  }

  @Override
  public SellModel toDomain(SellEntity entity) {
    if (entity == null) return null;
    SellModel model = new SellModel();
    model.setId(entity.getId());
    model.setValorTotal(entity.getValorTotal());
    model.setItens(itemSellMapper.toDomain(entity.getItens()));
    return model;
  }
}