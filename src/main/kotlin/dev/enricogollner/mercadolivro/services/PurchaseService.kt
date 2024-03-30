package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.events.PurchaseEvent
import dev.enricogollner.mercadolivro.models.PurchaseModel
import dev.enricogollner.mercadolivro.repositories.PurchaseRepository
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
        private val purchaseRepository: PurchaseRepository,
        private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel);

        println("Disparando evento de purchase")
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel));
        println("Finalização do processamento")
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
