package dev.enricogollner.mercadolivro.events.listenners

import dev.enricogollner.mercadolivro.events.PurchaseEvent
import dev.enricogollner.mercadolivro.services.BookService
import dev.enricogollner.mercadolivro.services.PurchaseService
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListenner(
        private val bookService: BookService
) {
    fun purchaseEventListner(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}