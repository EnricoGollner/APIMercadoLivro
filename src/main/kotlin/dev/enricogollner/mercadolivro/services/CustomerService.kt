package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.controllers.request.PutCustomerRequest
import dev.enricogollner.mercadolivro.models.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun create(customer: CustomerModel) {
        val newId = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()

        customer.id = newId

        customers.add(customer)
    }

    fun updateCustomer(customer: CustomerModel) {
        val customerToUpdtate = customers.first { it.id == customer.id }
        customerToUpdtate.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String) {
        customers.removeIf { it.id == id }
    }
}