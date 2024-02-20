package dev.enricogollner.mercadolivro.enums

enum class BookStatus {
    ATIVO,
    VENDIDO,
    CANCELADO,  // When the user cancels the book
    DELETADO  // When the user disactivates his account
}