package com.demo.hexagonal.store.infrastructure.controller

import com.demo.hexagonal.store.application.dto.CategoryDto
import com.demo.hexagonal.store.application.service.CategoryAppService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
@RequestMapping("categories")
class CategoryController(
        private val categoryAppService: CategoryAppService
) {

    @GetMapping
    fun getAll(): List<CategoryDto> {
        return categoryAppService.findAll()
    }

    @PostMapping
    fun create(@RequestBody categoryDto: CategoryDto) {
        categoryAppService.create(categoryDto)
    }

}