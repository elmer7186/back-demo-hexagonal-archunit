package com.demo.hexagonal.store.domain.model

import com.demo.hexagonal.store.domain.exception.RequiredValueException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class ProductTest {

    @Test
    fun `should fail when name is empty`() {
        val exception = assertThrows<RequiredValueException> {
            Product(
                    id = 1,
                    name = "",
                    description = "description",
                    category = Category(
                            id = 1,
                            name = "any",
                            description = null),
                    price = 32000.0)
        }
        assertEquals(Product.MESSAGE_NAME_REQUIRED, exception.message)
    }

    @Test
    fun `should fail when price is zero`() {
        val exception = assertThrows<RequiredValueException> {
            Product(
                    id = 1,
                    name = "Tv",
                    description = "description",
                    category = Category(
                            id = 1,
                            name = "any",
                            description = null),
                    price = 0.0)
        }
        assertEquals(Product.MESSAGE_PRICE_REQUIRED, exception.message)
    }

}