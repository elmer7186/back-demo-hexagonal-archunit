package com.demo.hexagonal.store.infrastructure.adapter.repository.mapper

import com.demo.hexagonal.store.domain.model.Category
import com.demo.hexagonal.store.infrastructure.adapter.repository.entity.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryMapper {

    private fun CategoryEntity.mapToDomain() = Category(
            id = id,
            name = name,
            description = description
    )

    fun toDomain(categoryEntity: CategoryEntity): Category {
        return categoryEntity.mapToDomain()
    }

    fun listToDomain(categiesEntity: List<CategoryEntity>): List<Category> {
        return categiesEntity.map { categoryEntity -> categoryEntity.mapToDomain() }
    }

}