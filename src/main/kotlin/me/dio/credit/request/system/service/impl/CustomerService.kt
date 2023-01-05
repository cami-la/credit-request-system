package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.dto.request.CustomerForm
import me.dio.credit.request.system.dto.request.CustomerUpdateForm
import me.dio.credit.request.system.dto.response.CustomerView
import me.dio.credit.request.system.model.Address
import me.dio.credit.request.system.model.Customer
import me.dio.credit.request.system.repository.CustomerRepository
import me.dio.credit.request.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
  private val customerRepository: CustomerRepository
) : ICustomerService {
  override fun save(customerForm: CustomerForm) {
    val customerToSave = customerForm.toEntity()
    this.customerRepository.save(customerToSave)
  }

  override fun update(customerUpdateForm: CustomerUpdateForm, id: Long): CustomerView {
    val customer: Customer = this.findById(id)
    val customerUpdated = customer.apply {
      firstName = customerUpdateForm.firstName
      lastName = customerUpdateForm.lastName
      address = Address(
        zipCode = customerUpdateForm.zipCode,
        street = customerUpdateForm.street
      )
      income = customerUpdateForm.income
    }
    val customerSaved: Customer = this.customerRepository.save(customerUpdated)
    return CustomerView(customerSaved)
  }

  override fun customerView(id: Long): CustomerView {
    val customer: Customer = this.findById(id)
    return CustomerView(customer)
  }

  override fun delete(id: Long) {
    val customerToDelete: Customer = this.findById(id)
    this.customerRepository.delete(customerToDelete)
  }

  fun findById(id: Long): Customer {
    return this.customerRepository.findById(id)
      .orElseThrow {
        throw RuntimeException("User not found")
      }
  }
}