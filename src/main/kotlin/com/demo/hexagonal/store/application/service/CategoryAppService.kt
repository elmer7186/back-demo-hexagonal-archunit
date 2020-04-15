package com.demo.hexagonal.store.application.service

import com.demo.hexagonal.store.application.dto.CategoryDto
import com.demo.hexagonal.store.application.mapper.CategoryAppMapper
import com.demo.hexagonal.store.domain.port.CategoryRepositoryPort
import com.demo.hexagonal.store.domain.service.CategoryService
import org.springframework.stereotype.Component

@Component
class CategoryAppService(
        private val categoryRepositoryPort: CategoryRepositoryPort,
        private val categoryService: CategoryService,
        private val categoryAppMapper: CategoryAppMapper
) {

    fun findAll(): List<CategoryDto> {
        return categoryAppMapper.listToDto(categoryRepositoryPort.findAll())
    }

    fun create(categoryDto: CategoryDto) {
        categoryService.create(categoryAppMapper.toDomain(categoryDto))
    }

}