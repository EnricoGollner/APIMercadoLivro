package dev.enricogollner.mercadolivro.controllers.request

data class AuthenticationRequest(
    val email: String,
    val password: String
)