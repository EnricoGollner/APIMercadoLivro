package dev.enricogollner.mercadolivro.extension

import dev.enricogollner.mercadolivro.controllers.request.PostBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PostCustomerRequest
import dev.enricogollner.mercadolivro.controllers.request.PutBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PutCustomerRequest
import dev.enricogollner.mercadolivro.controllers.response.BookResponse
import dev.enricogollner.mercadolivro.controllers.response.CustomerResponse
import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.enums.CustomerStatus
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(previousCustomer: CustomerModel): CustomerModel {
    return CustomerModel(previousCustomer.id, this.name, this.email, status = previousCustomer.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer)
}

fun PutBookRequest.toBookModel(previousBook: BookModel): BookModel {
    return BookModel(id = previousBook.id, name = this.name ?: previousBook.name, price = this.price ?: previousBook.price,
        status = previousBook.status, customer = previousBook.customer)
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}