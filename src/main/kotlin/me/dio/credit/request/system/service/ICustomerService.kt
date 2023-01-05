package me.dio.credit.request.system.service

import me.dio.credit.request.system.dto.request.CustomerForm
import me.dio.credit.request.system.dto.request.CustomerUpdateForm
import me.dio.credit.request.system.dto.response.CustomerView

interface ICustomerService {
  fun save(customerForm: CustomerForm) : Unit
  fun update(customerUpdateForm: CustomerUpdateForm, id: Long) : CustomerView
  fun customerView(id: Long) : CustomerView
  fun delete(id: Long) : Unit
}
