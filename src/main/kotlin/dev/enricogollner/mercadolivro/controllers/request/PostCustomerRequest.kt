package dev.enricogollner.mercadolivro.controllers.request

import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.validations.EmailAvaliable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

// DTO
data class PostCustomerRequest(
    @field:NotEmpty(message = "O nome deve ser informado!")
    var name: String,
    @field:Email(message = "O e-mail deve ser válido!")
    @EmailAvaliable
    var email: String,
    @field:NotEmpty(message = "A senha deve ser informada!")
    var password: String
)