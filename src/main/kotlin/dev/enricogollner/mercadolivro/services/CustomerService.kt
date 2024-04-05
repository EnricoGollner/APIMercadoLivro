package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.enums.CustomerStatus
import dev.enricogollner.mercadolivro.enums.Errors
import dev.enricogollner.mercadolivro.enums.Role
import dev.enricogollner.mercadolivro.exceptions.NotFoundException
import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.repositories.CustomerRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val bookService: BookService,
    private val bCrypt: BCryptPasswordEncoder
) {

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
        val customerCopy = customer.copy(
            roles = setOf(Role.CUSTOMER),
            password = bCrypt.encode(customer.password)
        )
        customerRepository.save(customerCopy)
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

    // Verifies if there's no account created with the e-mail
    fun isEmailAvaliable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}