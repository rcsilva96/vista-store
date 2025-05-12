package com.techvista.vistastore.infra.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class BaseMapper<E, M> {
  public abstract E toEntity(M model);
  public abstract M toDomain(E entity);

  public List<E> toEntity(List<M> models) {
    return models.stream()
        .map(this::toEntity)
        .collect(Collectors.toList());
  }

  public List<M> toDomain(List<E> entities) {
    return entities.stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }
}