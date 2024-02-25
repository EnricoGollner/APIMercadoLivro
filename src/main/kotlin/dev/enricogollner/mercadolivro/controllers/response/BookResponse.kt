package dev.enricogollner.mercadolivro.controllers.response

import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.models.CustomerModel
import java.math.BigDecimal

data class BookResponse (
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)
