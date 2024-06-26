package dev.enricogollner.mercadolivro.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name="purchase")
data class PurchaseModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @ManyToOne  // many purchases to one client
        @JoinColumn(name = "customer_id")
        val customer: CustomerModel,

        @ManyToMany  // many purchases to many books
        @JoinTable(  // We'll have an intermediate table to put together the purchase and books
                name = "purchase_book",
                joinColumns = [JoinColumn(name = "purchase_id")],
                inverseJoinColumns = [JoinColumn(name = "book_id")]
        )
        val books: MutableList<BookModel>,

        @Column
        val nfe: String? = null,

        @Column
        val price: BigDecimal,

        @Column(name = "created_at")
        val createdAt: LocalDateTime = LocalDateTime.now()
)