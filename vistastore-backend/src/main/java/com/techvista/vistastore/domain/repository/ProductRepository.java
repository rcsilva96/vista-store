package com.techvista.vistastore.domain.repository;

import com.techvista.vistastore.domain.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  ProductModel saveProduct(ProductModel productModel);
  Optional<ProductModel> findProductById(Long id);
  List<ProductModel> findAllProducts();
  void deleteProduct(Long id);
  Optional<ProductModel> findProductByBarCode(String barCode);

}
