package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.enums.CustomerStatus
import dev.enricogollner.mercadolivro.enums.Errors
import dev.enricogollner.mercadolivro.exceptions.NotFoundException
import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.respositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)  // it is the name
        }

        return customerRepository.findAll().toList()
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow { NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun updateCustomer(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        val customer = getCustomerById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }

    fun isEmailAvaliable(email: String): Boolean {
        return !(customerRepository.existsByEmail(email))
    }
}