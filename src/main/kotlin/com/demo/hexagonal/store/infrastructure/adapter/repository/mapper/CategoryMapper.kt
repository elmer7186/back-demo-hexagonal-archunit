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

    private fun Category.mapToEntity() = CategoryEntity(
            id = id,
            name = name,
            description = description
    )

    fun toDomain(categoryEntity: CategoryEntity): Category {
        return categoryEntity.mapToDomain()
    }

    fun listToDomain(categoriesEntity: List<CategoryEntity>): List<Category> {
        return categoriesEntity.map { categoryEntity -> categoryEntity.mapToDomain() }
    }

    fun toEntity(category: Category): CategoryEntity {
        return category.mapToEntity()
    }

}