package com.demo.hexagonal.store.infrastructure.controller

import com.demo.hexagonal.store.application.dto.CategoryDto
import com.demo.hexagonal.store.application.service.CategoryAppService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("categories")
class CategoryController(
        private val categoryAppService: CategoryAppService
) {

    @GetMapping
    fun getCategories(): List<CategoryDto> {
        return categoryAppService.findAll()
    }

}