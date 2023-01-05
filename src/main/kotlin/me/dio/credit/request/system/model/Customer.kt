package me.dio.credit.request.system.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Customer(
  @Column(nullable = false) var firstName: String,
  @Column(nullable = false) var lastName: String,
  @Column(nullable = false, unique = true) val cpf: String,
  @Column(nullable = false, unique = true) val email: String,
  @Column(nullable = false) val password: String,
  @Column(nullable = false) @Embedded var address: Address,
  @Column(nullable = false) var income: BigDecimal,
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer") val credits: List<Credit>,
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)