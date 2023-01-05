package me.dio.credit.request.system.dto.request

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.enummeration.Status
import me.dio.credit.request.system.model.Credit
import me.dio.credit.request.system.model.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditForm(
  @NotNull val creditValue: BigDecimal,
  @NotNull @Future val dayFirstInstallment: LocalDate,
  @Min(value = 1) @Max(value = 48) val numberOfInstallments: Int,
  @NotNull val customerId: Long
) {
  fun toEntity(customer: Customer): Credit {
    return Credit(
      creditCode = UUID.randomUUID(),
      creditValue = this.creditValue,
      dayFirstInstallment = this.dayFirstInstallment,
      numberOfInstallments = this.numberOfInstallments,
      status = Status.IN_PROGRESS,
      customer = customer
    )
  }
}
