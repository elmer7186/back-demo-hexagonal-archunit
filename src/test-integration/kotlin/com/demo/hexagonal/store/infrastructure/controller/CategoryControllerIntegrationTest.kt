package com.demo.hexagonal.store.infrastructure.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.transaction.Transactional

private const val CATEGORY_END_POINT = "/categories"

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CategoryControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should find all products when it is called`() {
        mockMvc.perform(get(CATEGORY_END_POINT)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }

}