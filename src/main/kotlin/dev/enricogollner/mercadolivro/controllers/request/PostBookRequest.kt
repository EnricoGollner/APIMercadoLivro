package dev.enricogollner.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (
    var name: String,

    var price: BigDecimal,

    @JsonAlias("customer_id") // naming in the request body
    var customerId: Int
)
