package dev.enricogollner.mercadolivro.controllers

import dev.enricogollner.mercadolivro.controllers.mapper.PurchaseMapper
import dev.enricogollner.mercadolivro.controllers.request.PostPurchaseRequest
import dev.enricogollner.mercadolivro.services.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("purchase")
class PurchaseController (
        private val purchaseService: PurchaseService,
        private val purchaseMapper: PurchaseMapper
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request));
    }
}