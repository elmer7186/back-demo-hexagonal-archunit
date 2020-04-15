package com.demo.hexagonal.store.infrastructure.config

import com.demo.hexagonal.store.domain.port.CategoryRepositoryPort
import com.demo.hexagonal.store.domain.service.CategoryService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainBeansConfig {

    @Bean
    fun categoryService(categoryRepositoryPort: CategoryRepositoryPort): CategoryService {
        return CategoryService(categoryRepositoryPort)
    }

}