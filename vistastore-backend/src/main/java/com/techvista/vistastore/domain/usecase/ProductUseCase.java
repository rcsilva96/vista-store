package com.techvista.vistastore.domain.usecase;

import com.techvista.vistastore.domain.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

  ProductModel createProduct(ProductModel productModel);
  Optional<ProductModel> findProductById(Long id);
  List<ProductModel> findAllProducts();
  void deleteProduct(Long id);

}
