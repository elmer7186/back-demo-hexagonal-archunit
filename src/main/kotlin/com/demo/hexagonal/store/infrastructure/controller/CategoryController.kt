package com.demo.hexagonal.store.infrastructure.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("categories")
class CategoryController {

    @GetMapping
    fun getCategories(): String {
        return "Response test"
    }

    @PostMapping
    fun createCategory() {

    }

}