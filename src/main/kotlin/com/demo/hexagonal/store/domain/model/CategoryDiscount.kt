package com.demo.hexagonal.store.domain.model

class CategoryDiscount(
        val id: Int,
        val discount: Double,
        val category: Category,
        val weekday: WeekdayType
)