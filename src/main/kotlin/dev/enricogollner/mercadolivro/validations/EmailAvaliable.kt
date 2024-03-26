package dev.enricogollner.mercadolivro.validations

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [EmailAvaliableValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class EmailAvaliable(
        val message: String = "E-mail já cadastrado!",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = [])
