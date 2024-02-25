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

    @ManyToOne  // Many books to one user - Relationship
    @JoinColumn(name = "customer_id") // as in migration V2 - We're saying that customer_id references id property/primary key of customer
    var customer: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(newValue) {
            // field is the old value
            if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO)
                throw Exception("Não é possível alterar um livro com status $field")

            field = newValue
        }


    constructor(id: Int? = null, name: String, price: BigDecimal, customer: CustomerModel? = null, status: BookStatus?)
    : this(id, name, price, customer) {
        this.status = status
    }
}