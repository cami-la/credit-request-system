package me.dio.credit.request.system.dto

import java.math.BigDecimal
import java.time.LocalDate

data class CreditForm(
  val creditValue: BigDecimal,
  val dayFirstInstallment: LocalDate,
  val numberOfInstallment: Int,
  val customerId: Long
)
