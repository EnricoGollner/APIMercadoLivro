package dev.enricogollner.mercadolivro.enums

enum class Errors(val code: String, val message: String) {
    ML001("ML-001", "Invalid Request."),
    ML101("ML-1001", "Book [%s] don't exist!"),
    ML102("ML-102", "Cannot update book with stats [%s]"),
    ML201("ML-1101", "Customer [%s] don't exist!"),
}