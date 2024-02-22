package dev.enricogollner.mercadolivro.controllers

import dev.enricogollner.mercadolivro.controllers.request.PostBookRequest
import dev.enricogollner.mercadolivro.controllers.request.PutBookRequest
import dev.enricogollner.mercadolivro.extension.toBookModel
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.services.BookService
import dev.enricogollner.mercadolivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.awt.print.Book

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllBooks(@RequestParam name: String?): List<BookModel> =
        bookService.getAllBooks()

    @GetMapping("/active")
    fun getActiveBooks(): List<BookModel> =
        bookService.getActiveBooks()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): BookModel =
        bookService.getBookById(id)

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