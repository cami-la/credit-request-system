package me.dio.credit.request.system.service

import me.dio.credit.request.system.dto.request.CreditForm
import me.dio.credit.request.system.dto.response.CreditListView
import me.dio.credit.request.system.dto.response.CreditView

interface ICreditService {
  fun save(creditForm: CreditForm)
  fun findAllByCustomer(idCustomer: Long) : List<CreditListView>
  fun creditView(idCredit: Long) : CreditView
}