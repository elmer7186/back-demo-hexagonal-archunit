package com.demo.hexagonal.store.application.mapper

import com.demo.hexagonal.store.application.dto.CategoryDto
import com.demo.hexagonal.store.domain.model.Category
import org.springframework.stereotype.Component

@Component
class CategoryAppMapper {

    private fun Category.mapToDto() = CategoryDto(
            id = id,
            name = name,
            description = description
    )

    fun toDto(category: Category): CategoryDto {
        return category.mapToDto()
    }

    fun listToDto(categories: List<Category>): List<CategoryDto> {
        return categories.map { category -> category.mapToDto() }
    }

}