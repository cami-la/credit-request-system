package me.dio.credit.request.system.service

import me.dio.credit.request.system.model.Credit

interface ICreditService {
  fun save() : Unit
  fun findById() : Credit
  fun findAllByCustomer() : List<Credit>
  fun findAll() : List<Credit>
}