package dev.enricogollner.mercadolivro.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Constraint(validatedBy = [EmailAvaliableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvaliable(
    val message: String = "E-mail já cadastrado!",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []

)