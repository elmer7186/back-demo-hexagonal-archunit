package com.demo.hexagonal.store.infrastructure.adapter.repository

import com.demo.hexagonal.store.domain.model.Category
import com.demo.hexagonal.store.domain.port.CategoryRepositoryPort
import com.demo.hexagonal.store.infrastructure.adapter.repository.jpa.CategoryJpaRepository
import com.demo.hexagonal.store.infrastructure.adapter.repository.mapper.CategoryMapper
import org.springframework.stereotype.Component

@Component
class CategoryRepositoryAdapter(
        private val categoryJpaRepository: CategoryJpaRepository,
        private val categoryMapper: CategoryMapper
) : CategoryRepositoryPort {

    override fun findAll(): List<Category> {
        return categoryMapper.listToDomain(categoryJpaRepository.findAll())
    }

}