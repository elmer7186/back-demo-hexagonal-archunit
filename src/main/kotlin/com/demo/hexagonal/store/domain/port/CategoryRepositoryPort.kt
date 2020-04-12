package com.demo.hexagonal.store.domain.port

import com.demo.hexagonal.store.domain.model.Category

interface CategoryRepositoryPort {

    fun findAll(): List<Category>
    
}