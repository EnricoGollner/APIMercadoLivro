package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.respositories.BookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class BookService(val bookRepository: BookRepository) {
    fun getAllBooks(): List<BookModel> =
        bookRepository.findAll().toList()

    fun createBook(book: BookModel) =
        bookRepository.save(book)

    fun getActiveBooks(): List<BookModel> =
        bookRepository.findByStatus(BookStatus.ATIVO)

    fun getBookById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow()

    fun deleteBook(id: Int) {  // Only disactive the book
        val book = getBookById(id)
        book.status = BookStatus.CANCELADO
        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }

}
