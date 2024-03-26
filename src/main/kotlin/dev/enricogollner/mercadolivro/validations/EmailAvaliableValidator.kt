package dev.enricogollner.mercadolivro.validations

import dev.enricogollner.mercadolivro.services.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

class EmailAvaliableValidator(var customerService: CustomerService): ConstraintValidator<EmailAvaliable, String> {
        override fun isValid(value: String?, p1: ConstraintValidatorContext?): Boolean {
                if (value.isNullOrEmpty()) {
                        return false
                }
                return customerService.emailAvaliable(value)
        }

}
