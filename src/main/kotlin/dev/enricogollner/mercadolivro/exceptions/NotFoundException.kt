package dev.enricogollner.mercadolivro.exceptions

class NotFoundException(override val message: String, val errorCode: String): Exception()