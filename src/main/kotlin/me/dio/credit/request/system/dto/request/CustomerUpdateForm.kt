package me.dio.credit.request.system.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateForm(
  @NotEmpty val firstName: String,
  @NotEmpty val lastName: String,
  @NotEmpty val zipCode: String,
  @NotEmpty val street: String,
  @NotNull val income: BigDecimal
)
