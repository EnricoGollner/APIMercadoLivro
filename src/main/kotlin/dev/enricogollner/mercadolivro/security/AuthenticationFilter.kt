package dev.enricogollner.mercadolivro.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dev.enricogollner.mercadolivro.controllers.request.AuthenticationRequest
import dev.enricogollner.mercadolivro.exceptions.AuthenticationException
import dev.enricogollner.mercadolivro.repositories.CustomerRepository
import dev.enricogollner.mercadolivro.repositories.PurchaseRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class AuthenticationFilter(authenticationManager: AuthenticationManager,
    private val customerRepository: CustomerRepository
    ): UsernamePasswordAuthenticationFilter(authenticationManager) {
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        try {
            val authenticationRequest = jacksonObjectMapper().readValue(request.inputStream, AuthenticationRequest::class.java)
            val id = customerRepository.findByEmail(authenticationRequest.email)?.id
            val authToken = UsernamePasswordAuthenticationToken(id, authenticationRequest.password)
            return authenticationManager.authenticate(authToken)
        } catch (e: Exception) {
            throw AuthenticationException("Falha ao autenticar", "999")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val id = (authResult.principal as UserCustomDetails).id
        response.addHeader("Authorization", "1234")
    }
}