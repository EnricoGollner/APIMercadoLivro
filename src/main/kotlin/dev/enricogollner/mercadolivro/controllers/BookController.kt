package dev.enricogollner.mercadolivro.controllers

import dev.enricogollner.mercadolivro.controllers.request.PostBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PutBookRequest
import dev.enricogollner.mercadolivro.controllers.response.BookResponse
import dev.enricogollner.mercadolivro.extension.toBookModel
import dev.enricogollner.mercadolivro.extension.toResponse
import dev.enricogollner.mercadolivro.services.BookService
import dev.enricogollner.mercadolivro.services.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.getAllBooks(pageable).map { it.toResponse() }

    @GetMapping("/active")
    fun getActiveBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.getActiveBooks(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): BookResponse =
        bookService.getBookById(id).toResponse()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomerById(request.customerId)
        bookService.createBook(request.toBookModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.getBookById(id)
        bookService.updateBook(book.toBookModel(bookSaved))
    }
}