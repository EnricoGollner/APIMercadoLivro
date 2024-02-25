package dev.enricogollner.mercadolivro.controllers.request

import dev.enricogollner.mercadolivro.models.CustomerModel

// DTO
data class PostCustomerRequest(var name: String, var email: String)