package dev.enricogollner.mercadolivro.validations

import dev.enricogollner.mercadolivro.services.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

class EmailAvaliableValidator(private val customerService: CustomerService): ConstraintValidator<EmailAvaliable, String> {
        override fun isValid(value: String?, p1: ConstraintValidatorContext?): Boolean {
                if (value.isNullOrEmpty()) {
                        return false
                }
                return customerService.isEmailAvaliable(value)
        }
}
