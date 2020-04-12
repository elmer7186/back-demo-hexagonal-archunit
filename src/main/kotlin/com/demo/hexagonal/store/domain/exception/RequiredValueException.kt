package com.demo.hexagonal.store.domain.exception

import java.lang.RuntimeException

class RequiredValueException(message: String?) : RuntimeException(message) {
}