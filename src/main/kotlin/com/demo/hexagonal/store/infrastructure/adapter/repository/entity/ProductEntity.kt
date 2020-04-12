package com.demo.hexagonal.store.infrastructure.adapter.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "product")
data class ProductEntity(
        @Id
        @GeneratedValue
        @Column(name = "id_product")
        val id: Int,

        @Column(nullable = false)
        val name: String,

        val description: String?,

        @ManyToOne
        @JoinColumn(name = "id_category")
        val category: CategoryEntity,

        @Column(nullable = false)
        val price: Double

)