package me.dio.credit.request.system.model

import jakarta.persistence.*
import me.dio.credit.request.system.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
data class Credit(
  @Column(nullable = false) val creditCode: UUID,
  @Column(nullable = false) val creditValue: BigDecimal,
  @Column(nullable = false) val dayFirstInstallment: LocalDate,
  @Column(nullable = false) val numberOfInstallments: Int,
  @Enumerated val status: Status,
  @ManyToOne val customer: Customer,
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)