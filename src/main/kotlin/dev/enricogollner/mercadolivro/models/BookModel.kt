package dev.enricogollner.mercadolivro.models

import dev.enricogollner.mercadolivro.enums.BookStatus
import jakarta.persistence.*
import java.awt.print.Book
import java.math.BigDecimal

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var price: BigDecimal,  // Good to work with money values
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,
    @ManyToOne  // Many books to one user - Relationship
    @JoinColumn(name = "customer_id") // as in migration V2 - We're saying that customer_id references id property/primary key of customer
    var customer: CustomerModel? = null
)