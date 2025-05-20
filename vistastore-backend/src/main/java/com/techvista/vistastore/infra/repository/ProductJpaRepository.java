package com.techvista.vistastore.infra.repository;

import com.techvista.vistastore.infra.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductJpaRepository  extends JpaRepository<ProductEntity, Long> {

Optional<ProductEntity> findByBarCode(String barCode);

}
