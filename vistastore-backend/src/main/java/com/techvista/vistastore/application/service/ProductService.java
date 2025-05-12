package com.techvista.vistastore.application.service;

import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.repository.ProductRepository;
import com.techvista.vistastore.domain.usecase.ProductUseCase;
import com.techvista.vistastore.infra.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductUseCase {
  
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
    this.productMapper = new ProductMapper();
  }
  
  @Override
  public ProductModel saveProduct(ProductModel product) {
    return productRepository.saveProduct(product);
  }

  @Override
  public ProductModel updateProduct(ProductModel product) {

    ProductModel existingProduct = productRepository.findProductById(product.getId())
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    return productRepository.saveProduct(product);

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
