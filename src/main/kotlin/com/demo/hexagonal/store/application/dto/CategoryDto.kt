package com.demo.hexagonal.store.application.dto

data class CategoryDto(
        val id: Int,
        val name: String,
        val description: String?
)