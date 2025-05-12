package com.techvista.vistastore.domain.repository;

import com.techvista.vistastore.domain.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  ProductModel createProduct(ProductModel productModel);
  Optional<ProductModel> findProductById(Long id);
  List<ProductModel> findAllProducts();
  void deleteProduct(Long id);

}
