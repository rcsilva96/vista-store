package com.techvista.vistastore.domain.usecase;

import com.techvista.vistastore.domain.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

  ProductModel saveProduct(ProductModel productModel);
  Optional<ProductModel> findProductById(Long id);
  ProductModel updateProduct(ProductModel product);
  List<ProductModel> findAllProducts();
  void deleteProduct(Long id);

}
