package com.demo.hexagonal.store.domain.exception

import java.lang.RuntimeException
import java.text.MessageFormat

class DuplicateDataException : RuntimeException {

    constructor(message: String) : super(message)

    constructor(message: String, vararg params: Any) : super(MessageFormat.format(message, *params))
}
