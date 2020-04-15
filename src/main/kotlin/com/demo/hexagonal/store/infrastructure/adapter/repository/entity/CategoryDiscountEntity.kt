package com.demo.hexagonal.store.infrastructure.adapter.repository.entity

import com.demo.hexagonal.store.domain.model.WeekdayType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator

@Entity(name = "category_discount")
data class CategoryDiscountEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORY_DISCOUNT")
        @SequenceGenerator(name = "SQ_CATEGORY_DISCOUNT", sequenceName = "SQ_CATEGORY_DISCOUNT", allocationSize = 1)
        @Column(name = "id_category_discount")
        val id: Int,

        @Column(nullable = false)
        val discount: Double,

        @ManyToOne
        @JoinColumn(name = "id_category")
        val category: CategoryEntity,

        val weekday: WeekdayType?

)