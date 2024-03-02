package dev.enricogollner.mercadolivro.controllers.request

import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal

data class PutBookRequest(
    var name: String?,
    var price: BigDecimal?
)
