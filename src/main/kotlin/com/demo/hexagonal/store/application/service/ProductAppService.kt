package com.demo.hexagonal.store.application.service

import com.demo.hexagonal.store.application.dto.ProductDto
import com.demo.hexagonal.store.application.mapper.ProductAppMapper
import com.demo.hexagonal.store.domain.port.ProductRepositoryPort
import org.springframework.stereotype.Component

@Component
class ProductAppService(
        private val productRepositoryPort: ProductRepositoryPort,
        private val productAppMapper: ProductAppMapper
) {

    fun findAll(): List<ProductDto> {
        return productAppMapper.listToDto(productRepositoryPort.findAll())
    }

}