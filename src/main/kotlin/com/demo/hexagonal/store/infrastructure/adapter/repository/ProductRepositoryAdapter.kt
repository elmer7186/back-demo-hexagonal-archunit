package com.demo.hexagonal.store.infrastructure.adapter.repository

import com.demo.hexagonal.store.domain.model.Product
import com.demo.hexagonal.store.domain.port.ProductRepositoryPort
import com.demo.hexagonal.store.infrastructure.adapter.repository.jpa.ProductJpaRepository
import com.demo.hexagonal.store.infrastructure.adapter.repository.mapper.ProductMapper
import org.springframework.stereotype.Component

@Component
class ProductRepositoryAdapter(
        private val productJpaRepository: ProductJpaRepository,
        private val productMapper: ProductMapper
) : ProductRepositoryPort {

    override fun findAll(): List<Product> {
        return productMapper.listToDomain(productJpaRepository.findAll())
    }

    override fun findByCategory(): List<Product> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}