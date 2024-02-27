package dev.enricogollner.mercadolivro.controllers.response

data class FieldErrorResponse(
    var message: String,
    var field: String,
)
