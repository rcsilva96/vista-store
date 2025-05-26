package com.techvista.vistastore.infra.repository;

import com.techvista.vistastore.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}