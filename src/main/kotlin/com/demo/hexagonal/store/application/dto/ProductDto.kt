package com.demo.hexagonal.store.application.dto

data class ProductDto(
        val id: Int,
        val name: String?,
        val description: String?,
        val category: CategoryDto,
        val price: Double,
        val discount: Double
)