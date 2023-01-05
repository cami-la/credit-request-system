package me.dio.credit.request.system.model

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
  var zipCode: String,
  var street: String
)
