package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.enums.Errors
import dev.enricogollner.mercadolivro.exceptions.NotFoundException
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.respositories.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {
    fun getAllBooks(pageable: Pageable): Page<BookModel> =
        bookRepository.findAll(pageable)

    fun createBook(book: BookModel) =
        bookRepository.save(book)

    fun getActiveBooks(pageable: Pageable): Page<BookModel> =
        bookRepository.findByStatus(BookStatus.ATIVO, pageable)

    fun getBookById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow { NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }

    fun deleteBook(id: Int) {  // Only disable the book
        val book = getBookById(id)
        book.status = BookStatus.CANCELADO
        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)

        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

}
