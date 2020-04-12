package com.demo.hexagonal.store.infrastructure.adapter.repository.entity

import com.demo.hexagonal.store.domain.model.WeekdayType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "category_discount")
data class CategoryDiscountEntity(

        @Id
        @GeneratedValue
        @Column(name = "id_category_discount")
        val id: Int,

        @Column(nullable = false)
        val discount: Double,

        @ManyToOne
        @JoinColumn(name = "id_category")
        val category: CategoryEntity,

        val weekday: WeekdayType?

)