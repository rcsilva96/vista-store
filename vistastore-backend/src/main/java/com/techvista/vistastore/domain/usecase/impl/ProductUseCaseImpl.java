package com.techvista.vistastore.domain.usecase.impl;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.repository.ProductRepository;
import com.techvista.vistastore.domain.usecase.ProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductUseCaseImpl implements ProductUseCase {

  private final ProductRepository productRepository;

  public ProductUseCaseImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ProductModel saveProduct(ProductModel productModel) {
    return productRepository.saveProduct(productModel);
  }

  @Override
  public ProductModel updateProduct(ProductModel product) {
    ProductModel existingProduct = productRepository.findProductById(product.getId())
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    return productRepository.saveProduct(product);
  }

  @Override
  public Optional<ProductModel> findProductById(Long id) {
    return productRepository.findProductById(id);
  }

  @Override
  public List<ProductModel> findAllProducts() {
    return productRepository.findAllProducts();
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteProduct(id);
  }

}
