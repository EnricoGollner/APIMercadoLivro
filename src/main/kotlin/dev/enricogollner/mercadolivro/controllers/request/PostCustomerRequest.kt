package dev.enricogollner.mercadolivro.controllers.request

import dev.enricogollner.mercadolivro.models.CustomerModel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

// DTO
data class PostCustomerRequest(
    @field: NotEmpty(message = "Name must be informed!")
    var name: String,
    @field:Email(message = "E-mail must be valid!")
    var email: String
)