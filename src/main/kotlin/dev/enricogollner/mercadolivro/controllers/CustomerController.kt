package dev.enricogollner.mercadolivro.controllers

import dev.enricogollner.mercadolivro.controllers.request.PostCustomerRequest
import dev.enricogollner.mercadolivro.controllers.request.PutCustomerRequest
import dev.enricogollner.mercadolivro.controllers.response.CustomerResponse
import dev.enricogollner.mercadolivro.enums.CustomerStatus
import dev.enricogollner.mercadolivro.extension.toCustomerModel
import dev.enricogollner.mercadolivro.extension.toResponse
import dev.enricogollner.mercadolivro.services.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    private val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.getCustomerById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerService.getCustomerById(id)
        customerService.updateCustomer(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }
}