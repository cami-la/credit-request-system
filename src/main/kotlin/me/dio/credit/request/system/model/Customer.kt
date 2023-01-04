package me.dio.credit.request.system.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Customer(
  @Column(nullable = false) val firstName: String,
  @Column(nullable = false) val lastName: String,
  @Column(nullable = false, unique = true) val cpf: String,
  @Column(nullable = false, unique = true) val email: String,
  @Column(nullable = false) val password: String,
  @Column(nullable = false) @Embedded val address: Address,
  @Column(nullable = false) val income: BigDecimal,
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer") val credits: List<Credit>,
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long
)