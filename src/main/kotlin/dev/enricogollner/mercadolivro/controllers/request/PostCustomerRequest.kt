package dev.enricogollner.mercadolivro.controllers.request

import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.validations.EmailAvaliable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

// DTO
data class PostCustomerRequest(
    @field:NotEmpty
    var name: String,
    @field:Email
    @EmailAvaliable
    var email: String
)