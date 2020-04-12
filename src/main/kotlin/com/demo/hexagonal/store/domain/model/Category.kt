package com.demo.hexagonal.store.domain.model

import com.demo.hexagonal.store.domain.exception.RequiredValueException

data class Category(
        val id: Int,
        val name: String,
        val description: String?
) {

    companion object {
        const val MESSAGE_NAME_REQUIRED = "Category Name is required"
    }

    init {
        require(name.isNotBlank()) { throw RequiredValueException(MESSAGE_NAME_REQUIRED) }
    }
}