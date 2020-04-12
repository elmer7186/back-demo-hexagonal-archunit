package com.demo.hexagonal.store.application.mapper

import com.demo.hexagonal.store.application.dto.ProductDto
import com.demo.hexagonal.store.domain.model.Product
import org.springframework.stereotype.Component

@Component
class ProductAppMapper(
        private val categoryAppMapper: CategoryAppMapper
) {

    private fun Product.mapToDto() = ProductDto(
            id = id,
            name = name,
            description = description,
            category = categoryAppMapper.toDto(category),
            price = price,
            discount = 0.0
    )

    fun listToDto(products: List<Product>): List<ProductDto> {
        return products.map { product -> product.mapToDto() }
    }

}