package com.demo.hexagonal.store.infrastructure.controller

import com.demo.hexagonal.store.application.dto.ProductDto
import com.demo.hexagonal.store.application.service.ProductAppService
import com.demo.hexagonal.store.domain.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

//    @GetMapping
//    fun getProductsByCategory(@RequestParam categoryName: String) {
//
//    }
//
//    @PostMapping
//    fun createProduct(){
//
//    }

}