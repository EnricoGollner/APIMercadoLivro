package dev.enricogollner.mercadolivro.controllers.mapper

import dev.enricogollner.mercadolivro.controllers.request.PostPurchaseRequest
import dev.enricogollner.mercadolivro.models.PurchaseModel
import dev.enricogollner.mercadolivro.services.BookService
import dev.enricogollner.mercadolivro.services.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
        private val bookService: BookService,
        private val customerService: CustomerService
) {
    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.getCustomerById(request.customerId);
        val books = bookService.findAllByIds(request.bookIds);

        return PurchaseModel(
                customer = customer,
                books = books.toMutableList(),
                price = books.sumOf { it.price }
        );
    }
}