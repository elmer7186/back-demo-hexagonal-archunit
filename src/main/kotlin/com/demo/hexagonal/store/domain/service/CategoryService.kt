package com.demo.hexagonal.store.domain.service

import com.demo.hexagonal.store.domain.exception.DuplicateDataException
import com.demo.hexagonal.store.domain.model.Category
import com.demo.hexagonal.store.domain.port.CategoryRepositoryPort

private const val MESSAGE_DUPLICATE_ERROR = "Existing category with name {0}"

class CategoryService(
        private val categoryRepositoryPort: CategoryRepositoryPort
) {

    fun create(category: Category) {
        val existCategory: Category? = categoryRepositoryPort.findByName(category.name)
        if (existCategory != null) {
            throw DuplicateDataException(MESSAGE_DUPLICATE_ERROR, category.name)
        }
        categoryRepositoryPort.save(category)
    }

}