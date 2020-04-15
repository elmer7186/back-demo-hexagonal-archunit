package com.demo.hexagonal.store.infrastructure.adapter.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity(name = "category")
data class CategoryEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORY")
        @SequenceGenerator(name = "SQ_CATEGORY", sequenceName = "SQ_CATEGORY", allocationSize = 1)
        @Column(name = "id_category")
        val id: Int,

        @Column(nullable = false)
        val name: String,

        val description: String?

)