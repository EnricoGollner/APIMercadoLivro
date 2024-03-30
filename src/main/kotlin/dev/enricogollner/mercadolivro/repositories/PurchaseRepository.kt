package dev.enricogollner.mercadolivro.repositories

import dev.enricogollner.mercadolivro.models.CustomerModel
import dev.enricogollner.mercadolivro.models.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<PurchaseModel, Int> {
}
