package com.techvista.vistastore.application.service;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.repository.ProductRepository;
import com.techvista.vistastore.domain.usecase.ProductUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductUseCase {
  
  private final ProductRepository productRepository;
  
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  @Override
  public ProductModel createProduct(ProductModel product) {
    return productRepository.createProduct(product);
  }
  
  @Override
  public List<ProductModel> findAllProducts() {
    return productRepository.findAllProducts();
  }
  
  public Optional<ProductModel> findProductById(Long id) {
    return productRepository.findProductById(id);
  }
  
  public void deleteProduct(Long id) {
    productRepository.deleteProduct(id);
  }
  
}
