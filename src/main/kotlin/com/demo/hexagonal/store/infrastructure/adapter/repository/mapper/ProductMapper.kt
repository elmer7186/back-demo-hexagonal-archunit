package com.demo.hexagonal.store.infrastructure.adapter.repository.mapper

import com.demo.hexagonal.store.domain.model.Product
import com.demo.hexagonal.store.infrastructure.adapter.repository.entity.ProductEntity
import org.springframework.stereotype.Component

@Component
class ProductMapper(
        private val categoryMapper: CategoryMapper
) {

    private fun ProductEntity.mapToDomain() = Product(
            id = id,
            name = name,
            description = description,
            category = categoryMapper.toDomain(category),
            price = price
    )

    fun toDomain(productEntity: ProductEntity): Product {
        return productEntity.mapToDomain()
    }

    fun listToDomain(productsEntity: List<ProductEntity>): List<Product> {
        return productsEntity.map { productEntity -> productEntity.mapToDomain() }
    }

}