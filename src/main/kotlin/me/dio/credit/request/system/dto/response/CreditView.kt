package me.dio.credit.request.system.dto.response

import me.dio.credit.request.system.model.Credit
import java.math.BigDecimal
import java.util.*

data class CreditView(
  val creditCode: UUID,
  val creditValue: BigDecimal,
  val numberOfInstallment: Int,
  val status: String,
  val emailCustomer: String,
  val incomeCustomer: BigDecimal
) {
  constructor(credit: Credit) : this(
    creditCode = credit.creditCode,
    creditValue = credit.creditValue,
    numberOfInstallment = credit.numberOfInstallments,
    status = credit.status.name,
    emailCustomer = credit.customer.email,
    incomeCustomer = credit.customer.income
  )
}
