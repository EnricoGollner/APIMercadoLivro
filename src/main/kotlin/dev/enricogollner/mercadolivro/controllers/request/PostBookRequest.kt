package dev.enricogollner.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostBookRequest (
    @field: NotEmpty(message = "Name must be informed!")
    var name: String,
    @field: NotNull(message = "Price must be informed!")
    var price: BigDecimal,

    @JsonAlias("customer_id") // naming in the request body
    var customerId: Int
)
