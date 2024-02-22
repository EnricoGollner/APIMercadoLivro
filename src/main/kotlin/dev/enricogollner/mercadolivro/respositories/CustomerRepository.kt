package dev.enricogollner.mercadolivro.respositories

import dev.enricogollner.mercadolivro.models.CustomerModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

interface CustomerRepository: CrudRepository<CustomerModel, Int>{
    fun findByNameContaining(name: String): List<CustomerModel>
}