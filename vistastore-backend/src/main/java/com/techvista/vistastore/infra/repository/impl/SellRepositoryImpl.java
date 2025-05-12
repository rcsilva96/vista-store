package com.techvista.vistastore.infra.repository.impl;

import com.techvista.vistastore.domain.model.SellModel;
import com.techvista.vistastore.domain.repository.SellRepository;
import com.techvista.vistastore.infra.entity.SellEntity;
import com.techvista.vistastore.infra.mapper.SellMapper;
import com.techvista.vistastore.infra.repository.SellJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SellRepositoryImpl implements SellRepository {
  private final SellJpaRepository sellJpaRepository;
  private final SellMapper sellMapper;

  public SellRepositoryImpl(SellJpaRepository sellJpaRepository, SellMapper sellMapper) {
    this.sellJpaRepository = sellJpaRepository;
    this.sellMapper = sellMapper;
  }

  @Override
  public SellModel saveSell(SellModel sellModel) {
    SellEntity entity = sellMapper.toEntity(sellModel);
    SellEntity savedEntity = sellJpaRepository.save(entity);
    return sellMapper.toDomain(savedEntity);
  }

  @Override
  public SellModel findSellById(Long id) {
    return sellJpaRepository.findById(id)
        .map(sellMapper::toDomain)
        .orElse(null);
  }
}