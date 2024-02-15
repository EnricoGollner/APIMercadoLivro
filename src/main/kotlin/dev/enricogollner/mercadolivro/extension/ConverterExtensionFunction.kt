package dev.enricogollner.mercadolivro.extension

import dev.enricogollner.mercadolivro.controllers.request.PostCustomerRequest
import dev.enricogollner.mercadolivro.controllers.request.PutCustomerRequest
import dev.enricogollner.mercadolivro.models.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id, this.name, this.email)
}