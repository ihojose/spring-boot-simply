package com.ihojose.umb.spring.guia6.controller;

import com.ihojose.umb.spring.guia6.entities.ProductEntity;
import com.ihojose.umb.spring.guia6.entities.Respuesta;
import com.ihojose.umb.spring.guia6.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
@RestController
@RequestMapping("api")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductEntity>> getProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> getOne(@PathVariable String id) {
        Optional<ProductEntity> p = productRepository.findById(Long.parseLong(id));
        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado.");
        }
    }

    @PostMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Respuesta> saveProduct(@RequestBody ProductEntity data) {
        productRepository.save(data);
        return ResponseEntity.ok(new Respuesta("Producto creado."));
    }

    @PutMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Respuesta> modifyProduct(@RequestBody ProductEntity data) {

        ProductEntity p = productRepository.getById(data.getId());
        p.setName(data.getName());
        p.setDescription(data.getDescription());
        p.setPrice(data.getPrice());
        p.setImage(data.getImage());

        productRepository.save(p);

        return ResponseEntity.ok(new Respuesta("Producto modificado exitosamente."));
    }

    @DeleteMapping(value = "products/{id}")
    public ResponseEntity<Respuesta> deleteProduct(@PathVariable String id) {
        productRepository.delete(productRepository.getById(Long.parseLong(id)));

        return ResponseEntity.ok(new Respuesta("Producto eliminado exitosamente."));
    }
}
