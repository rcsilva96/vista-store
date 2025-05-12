package com.techvista.vistastore.infra.mapper;

import com.techvista.vistastore.domain.model.ItemSellModel;
import com.techvista.vistastore.infra.entity.ItemSellEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemSellMapper extends BaseMapper<ItemSellEntity, ItemSellModel> {
  private final ProductMapper productMapper;

  public ItemSellMapper(ProductMapper productMapper) {
    this.productMapper = productMapper;
  }

  @Override
  public ItemSellEntity toEntity(ItemSellModel model) {
    if (model == null) return null;
    ItemSellEntity entity = new ItemSellEntity();
    entity.setId(model.getId());
    entity.setProduct(productMapper.toEntity(model.getProduct()));
    entity.setQuantity(model.getQuantity());
    entity.setUnitPrice(model.getUnitPrice());
    return entity;
  }

  @Override
  public ItemSellModel toDomain(ItemSellEntity entity) {
    if (entity == null) return null;
    ItemSellModel model = new ItemSellModel();
    model.setId(entity.getId());
    model.setProduct(productMapper.toDomain(entity.getProduct()));
    model.setQuantity(entity.getQuantity());
    model.setUnitPrice(entity.getUnitPrice());
    return model;
  }
}