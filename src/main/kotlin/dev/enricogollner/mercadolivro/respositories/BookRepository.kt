package dev.enricogollner.mercadolivro.respositories

import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.models.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
     fun findByStatus(ativo: BookStatus): List<BookModel>

}