package me.dio.credit.request.system.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import me.dio.credit.request.system.model.Address
import me.dio.credit.request.system.model.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerForm(
  @NotEmpty val firstName: String,
  @NotEmpty val lastName: String,
  @NotEmpty @CPF val cpf: String,
  @NotEmpty
  @Pattern(
    regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}",
    message = "Please provide a valid email address"
  ) val email: String,
  @NotEmpty val password: String,
  @NotEmpty val zipCode: String,
  @NotEmpty val street: String,
  @NotNull val income: BigDecimal
) {
  fun toEntity(): Customer {
    return Customer(
      firstName = this.firstName,
      lastName = this.lastName,
      cpf = this.cpf,
      email = this.email,
      password = this.password,
      address = Address(
        zipCode = this.zipCode,
        street = this.street
      ),
      income = this.income,
      credits = mutableListOf()
    )
  }
}
