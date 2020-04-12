package com.demo.hexagonal.store.infrastructure.adapter.repository.jpa

import com.demo.hexagonal.store.infrastructure.adapter.repository.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryJpaRepository : JpaRepository<CategoryEntity, Int>