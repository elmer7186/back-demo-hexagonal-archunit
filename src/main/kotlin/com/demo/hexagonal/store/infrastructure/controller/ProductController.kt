package com.demo.hexagonal.store.infrastructure.controller

import com.demo.hexagonal.store.application.dto.ProductDto
import com.demo.hexagonal.store.application.service.ProductAppService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductController(
        private val productAppService: ProductAppService
) {

    @GetMapping
    fun getProducts(): List<ProductDto> {
        return productAppService.findAll()
    }

}