package com.demo.hexagonal.store.infrastructure.controller.advice

import com.demo.hexagonal.store.domain.exception.DuplicateDataException
import com.demo.hexagonal.store.domain.exception.RequiredValueException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

private const val MESSAGE_UNEXPECTED_EXCEPTION = "Unexpected exception."

@ControllerAdvice
class AdviceController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [RequiredValueException::class])
    fun handleBadRequestException(exception: Exception): ResponseEntity<ErrorContent> {
        return ResponseEntity(ErrorContent(exception.javaClass.simpleName, exception.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [DuplicateDataException::class])
    fun handleConflictException(exception: Exception): ResponseEntity<ErrorContent> {
        return ResponseEntity(ErrorContent(exception.javaClass.simpleName, exception.message), HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleUnexpectedException(exception: Exception): ResponseEntity<ErrorContent> {
        return ResponseEntity(ErrorContent(exception.javaClass.simpleName, MESSAGE_UNEXPECTED_EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR)
    }

}