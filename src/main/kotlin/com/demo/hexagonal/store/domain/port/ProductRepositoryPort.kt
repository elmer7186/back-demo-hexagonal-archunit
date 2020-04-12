package com.demo.hexagonal.store.domain.port

import com.demo.hexagonal.store.domain.model.Product

interface ProductRepositoryPort {

    fun findAll(): List<Product>

    fun findByCategory(): List<Product>

}