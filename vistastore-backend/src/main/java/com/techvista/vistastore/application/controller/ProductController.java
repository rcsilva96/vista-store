package com.techvista.vistastore.application.controller;

import com.techvista.vistastore.application.service.ProductService;
import com.techvista.vistastore.domain.model.ProductModel;
import com.techvista.vistastore.domain.usecase.ProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductUseCase productUseCase;
  private final ProductService productService;

  public ProductController(ProductUseCase productUseCase, ProductService productService) {
    this.productUseCase = productUseCase;
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
    ProductModel createdProduct = productUseCase.saveProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductModel> updateProduct(
      @PathVariable Long id,
      @RequestBody ProductModel product) {

    product.setId(id);
    ProductModel updatedProduct = productService.updateProduct(product);
    return ResponseEntity.ok(updatedProduct);
  }

  @GetMapping
  public ResponseEntity<List<ProductModel>> findAllProducts() {
    List<ProductModel> productList = productUseCase.findAllProducts();
    return ResponseEntity.ok(productList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductModel> findProductById(@PathVariable Long id) {
    return productUseCase.findProductById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productUseCase.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

}
