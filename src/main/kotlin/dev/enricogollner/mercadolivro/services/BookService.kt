package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.respositories.BookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class BookService(val bookRepository: BookRepository) {
    fun getBooks() {

    }

    @ResponseStatus(HttpStatus.CREATED)
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
