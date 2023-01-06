package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.dto.request.CreditForm
import me.dio.credit.request.system.dto.response.CreditListView
import me.dio.credit.request.system.dto.response.CreditView
import me.dio.credit.request.system.model.Credit
import me.dio.credit.request.system.repository.CreditRepository
import me.dio.credit.request.system.service.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.stream.Collectors

@Service
class CreditService(
  private val creditRepository: CreditRepository,
  private val customerService: CustomerService
) : ICreditService {
  override fun save(creditForm: CreditForm) {
    if(this.validDateFirstInstallment(creditForm.dayFirstInstallment)) {
      val customer = customerService.findById(creditForm.customerId)
      val creditToSave = this.creditRepository.save(
        creditForm.toEntity(customer)
      )
      this.creditRepository.save(creditToSave)
    } else {
      throw RuntimeException("Date Invalid!")
    }
  }

  private fun validDateFirstInstallment(dateFirstInstallment: LocalDate): Boolean {
    val deadline: LocalDate = LocalDate.now().plusMonths(3)
    return dateFirstInstallment <= deadline
  }

  override fun findAllByCustomer(idCustomer: Long): List<CreditListView> {
    val customer = customerService.findById(idCustomer)
    return customer.credits.stream()
      .map { c -> CreditListView(c) }
      .collect(Collectors.toList())
  }

  override fun creditView(idCredit: Long): CreditView {
    val credit: Credit = this.creditRepository.findById(idCredit).orElseThrow {
      throw RuntimeException("Credit not found")
    }
    return CreditView(credit)
  }
}