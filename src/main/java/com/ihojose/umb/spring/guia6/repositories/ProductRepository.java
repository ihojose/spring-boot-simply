package com.ihojose.umb.spring.guia6.repositories;

import com.ihojose.umb.spring.guia6.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
