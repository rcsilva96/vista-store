package com.techvista.vistastore.infra.mapper;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.infra.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductModel toDomain(ProductEntity entity) {
    if (entity == null) {
      return null;
    }
    ProductModel model = new ProductModel();
    model.setId(entity.getId());
    model.setName(entity.getName());
    model.setPrice(entity.getPrice());
    model.setDescription(entity.getDescription());
    model.setStock(entity.getStock());
    return model;
  }

  public ProductEntity toEntity(ProductModel model){

    if (model == null) {
      return null;
    }

    ProductEntity entity = new ProductEntity();
    entity.setId(model.getId());
    entity.setName(model.getName());
    entity.setPrice(model.getPrice());
    entity.setDescription(model.getDescription());
    entity.setStock(model.getStock());
    return entity;

  }

}
