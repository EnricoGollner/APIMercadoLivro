package dev.enricogollner.mercadolivro.events

import dev.enricogollner.mercadolivro.models.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
        source: Any,
        val purchaseModel: PurchaseModel
): ApplicationEvent(source)