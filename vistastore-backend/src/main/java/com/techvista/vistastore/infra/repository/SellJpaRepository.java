package com.techvista.vistastore.infra.repository;

import com.techvista.vistastore.infra.entity.SellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellJpaRepository extends JpaRepository<SellEntity, Long> {
}
