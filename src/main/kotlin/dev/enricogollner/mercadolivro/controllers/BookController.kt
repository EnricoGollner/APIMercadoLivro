package dev.enricogollner.mercadolivro.controllers

import dev.enricogollner.mercadolivro.controllers.request.PostBookRequest
import dev.enricogollner.mercadolivro.extension.toBookModel
import dev.enricogollner.mercadolivro.services.BookService
import dev.enricogollner.mercadolivro.services.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun getBooks() {
        
    }

    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomerById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}