package dev.enricogollner.mercadolivro.models

import dev.enricogollner.mercadolivro.enums.CustomerStatus
import dev.enricogollner.mercadolivro.enums.Profile
import jakarta.persistence.*

@Entity(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    @Column
    val password: String,

    @Column(name = "role")
    @CollectionTable( //Tabela que não tem ID se torna uma collection table
        name = "customer_roles",
        joinColumns = [JoinColumn(name="customer_id")]
    )
    @ElementCollection(
        targetClass = Profile::class,
        fetch = FetchType.EAGER  // Toda vez que formos buscar um customer, também queremos estas roles
    )
    @Enumerated(EnumType.STRING)
    val roles: Set<Profile> = setOf()
)