package com.ihojose.umb.spring.guia6.repositories;

import com.ihojose.umb.spring.guia6.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright (c) 2021 Banco de Bogotá. All Rights Reserved.
 * <p>
 * Guia6 was developed by Core Banking (Gerencia de Desarrollo)
 * <p>
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * proprietary and confidential. For use this code you need to contact to
 * Banco de Bogotá and request exclusive use permission.
 * <p>
 * This file was write by Jose Buelvas <jbuelva@bancodebogota.com.co>.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
