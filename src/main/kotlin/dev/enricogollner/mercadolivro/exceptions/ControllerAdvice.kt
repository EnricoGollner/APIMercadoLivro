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
    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            400,
            "Este recurso não existe",
            internalCode = "0001",
            null
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

}