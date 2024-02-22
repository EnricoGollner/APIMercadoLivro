package dev.enricogollner.mercadolivro.extension

import dev.enricogollner.mercadolivro.controllers.request.PostBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PostCustomerRequest
import dev.enricogollner.mercadolivro.controllers.request.PutBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PutCustomerRequest
import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id, this.name, this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun PutBookRequest.toBookModel(previousBook: BookModel): BookModel {
    return BookModel(id = previousBook.id, name = this.name ?: previousBook.name, price = this.price ?: previousBook.price,
        status = previousBook.status, customer = previousBook.customer)
}