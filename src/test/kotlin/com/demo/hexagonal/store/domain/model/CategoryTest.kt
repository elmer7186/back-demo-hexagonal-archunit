package com.demo.hexagonal.store.domain.model

import com.demo.hexagonal.store.domain.exception.RequiredValueException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class CategoryTest {

    @Test
    fun `should fail when category name is empty`() {
        val exception = assertThrows<RequiredValueException> {
            Category(
                    id = 1,
                    name = "",
                    description = null
            )
        }
        assertEquals(Category.MESSAGE_NAME_REQUIRED, exception.message)
    }

}