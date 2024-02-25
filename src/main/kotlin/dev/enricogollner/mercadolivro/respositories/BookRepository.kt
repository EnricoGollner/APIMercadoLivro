package dev.enricogollner.mercadolivro.respositories

import dev.enricogollner.mercadolivro.enums.BookStatus
import dev.enricogollner.mercadolivro.models.BookModel
import dev.enricogollner.mercadolivro.models.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BookModel, Int> {
     fun findByStatus(ativo: BookStatus, pageable: Pageable): Page<BookModel>
     fun findByCustomer(customer: CustomerModel): List<BookModel>

     // Uma das formas para funcionar a paginação dos books:
//     fun findAll(pageable: Pageable): Page<BookModel>

}