package me.dio.credit.request.system.service

import me.dio.credit.request.system.model.Customer

interface ICustomerService {
  fun save() : Unit
  fun findById() : Customer
  fun findAll() : List<Customer>
  fun update() : Customer
  fun delete() : Unit
}