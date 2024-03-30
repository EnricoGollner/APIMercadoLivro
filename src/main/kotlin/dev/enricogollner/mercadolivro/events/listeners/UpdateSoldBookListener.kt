package dev.enricogollner.mercadolivro.events.listeners

import dev.enricogollner.mercadolivro.events.PurchaseEvent
import dev.enricogollner.mercadolivro.services.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListener(
        private val bookService: BookService
) {
    @Async
    @EventListener
    fun purchaseEventListenerUpdateBook(purchaseEvent: PurchaseEvent) {
        println("Atualizando status")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}