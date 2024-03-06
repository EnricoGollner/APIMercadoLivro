package dev.enricogollner.mercadolivro.validation

import dev.enricogollner.mercadolivro.services.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvaliableValidator(val customerService: CustomerService): ConstraintValidator<EmailAvaliable, String> {
    override fun isValid(value: String?, p1: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return customerService.isEmailAvaliable(value)
    }

}
