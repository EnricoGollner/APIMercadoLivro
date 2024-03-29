package dev.enricogollner.mercadolivro.controllers.request

import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class PostPurchaseRequest (
        @field:NotNull
        @field:Positive  // Positive numbers only (>0)
        val customerId: Int,
        @field:NotNull
        val bookIds: Set<Int>,

) {

}
