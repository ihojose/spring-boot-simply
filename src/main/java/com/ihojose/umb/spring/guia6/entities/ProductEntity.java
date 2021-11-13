package com.ihojose.umb.spring.guia6.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "image")
    private String image;
}
