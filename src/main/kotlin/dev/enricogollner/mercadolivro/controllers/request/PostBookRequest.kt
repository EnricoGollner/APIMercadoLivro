package dev.enricogollner.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

data class PostBookRequest (
    @field: NotEmpty(message = "O nome do livro precisa ser informado")
    var name: String,
    @field: NotNull("O preço do livro precisa ser informado")
    var price: BigDecimal,

    @JsonAlias("customer_id") // naming in the request body
    var customerId: Int
)
