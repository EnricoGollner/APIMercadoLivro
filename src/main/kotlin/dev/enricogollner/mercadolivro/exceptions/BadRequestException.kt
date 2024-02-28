package dev.enricogollner.mercadolivro.exceptions

class BadRequestException(override val message: String, val errorCode: String): Exception()