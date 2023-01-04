package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.model.Credit
import me.dio.credit.request.system.model.Customer
import me.dio.credit.request.system.repository.CreditRepository
import me.dio.credit.request.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService (
  private val creditRepository: CreditRepository
) : ICustomerService {

  override fun save() {
    TODO("Not yet implemented")
  }

  override fun findById(): Customer {
    TODO("Not yet implemented")
  }

  override fun findAll(): List<Customer> {
    return this.creditRepository.findAll()
  }

  override fun update(): Customer {
    TODO("Not yet implemented")
  }

  override fun delete() {
    TODO("Not yet implemented")
  }
}