package com.demo.hexagonal.store.domain.model

import com.demo.hexagonal.store.domain.exception.RequiredValueException

data class Product(
        val id: Int,
        val name: String,
        val description: String?,
        val category: Category,
        val price: Double
) {

    companion object {
        const val MESSAGE_NAME_REQUIRED = "Product name is required"
        const val MESSAGE_PRICE_REQUIRED = "Product price is required"
    }

    init {
        require(name.isNotBlank()) { throw RequiredValueException(MESSAGE_NAME_REQUIRED) }
        require(price > 0.0) { throw RequiredValueException(MESSAGE_PRICE_REQUIRED) }
    }
}