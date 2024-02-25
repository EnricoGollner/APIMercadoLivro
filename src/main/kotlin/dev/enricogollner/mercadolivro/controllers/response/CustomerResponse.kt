package dev.enricogollner.mercadolivro.controllers.response

import dev.enricogollner.mercadolivro.enums.CustomerStatus

data class CustomerResponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
