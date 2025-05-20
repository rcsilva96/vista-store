package com.techvista.vistastore.infra.repository.impl;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.repository.ProductRepository;
import com.techvista.vistastore.infra.entity.ProductEntity;
import com.techvista.vistastore.infra.mapper.ProductMapper;
import com.techvista.vistastore.infra.repository.ProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private final ProductJpaRepository productJpaRepository;
  private final ProductMapper productMapper;

  public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
    this.productJpaRepository = productJpaRepository;
    this.productMapper = new ProductMapper();
  }

  @Override
  public ProductModel saveProduct(ProductModel product) {
    ProductEntity entity = productMapper.toEntity(product);
    ProductEntity savedEntity = productJpaRepository.save(entity);
    return productMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<ProductModel> findProductById(Long id) {
    return productJpaRepository.findById(id)
        .map(productMapper::toDomain);
  }

  @Override
  public List<ProductModel> findAllProducts() {
    return productJpaRepository.findAll()
        .stream()
        .map(productMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteProduct(Long id) {
    productJpaRepository.deleteById(id);
  }

  @Override
  public Optional<ProductModel> findProductByBarCode(String barCode) {
    return productJpaRepository.findByBarCode(barCode)
        .map(productMapper::toDomain);
  }

}
