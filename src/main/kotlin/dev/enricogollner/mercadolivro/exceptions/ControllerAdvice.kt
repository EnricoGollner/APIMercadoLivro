package dev.enricogollner.mercadolivro.exceptions

import dev.enricogollner.mercadolivro.controllers.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

// Controller responsável por cuidar de todas as respostas das exceptions da nossa aplicação
@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handleException(exception: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            HttpStatus.NOT_FOUND.value(), // 404
            exception.message,
            internalCode = exception.errorCode,
            null
        )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

}