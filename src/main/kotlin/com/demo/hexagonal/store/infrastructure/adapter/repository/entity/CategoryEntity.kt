package com.demo.hexagonal.store.infrastructure.adapter.repository.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "category")
data class CategoryEntity(

        @Id
        @GeneratedValue
        @Column(name = "id_category")
        val id: Int,

        @Column(nullable = false)
        val name: String,

        val description: String?

)