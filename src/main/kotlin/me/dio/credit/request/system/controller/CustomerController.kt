package me.dio.credit.request.system.controller

import jakarta.validation.Valid
import me.dio.credit.request.system.dto.request.CustomerForm
import me.dio.credit.request.system.dto.request.CustomerUpdateForm
import me.dio.credit.request.system.dto.response.CustomerView
import me.dio.credit.request.system.service.impl.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(
  private val customerService: CustomerService
) {

  @GetMapping("/{id}")
  fun customerView(@PathVariable id: Long) : ResponseEntity<CustomerView> {
    return ResponseEntity.ok().body(this.customerService.customerView(id))
  }

  @PutMapping("/{id}")
  fun customerUpdate(
    @RequestBody @Valid customerUpdateForm: CustomerUpdateForm,
    @PathVariable id: Long) : ResponseEntity<CustomerView>{
    return ResponseEntity.ok().body(this.customerService.update(customerUpdateForm, id))
  }

  @DeleteMapping("/{id}")
  fun customerDelete(@PathVariable id: Long) {
    return this.customerDelete(id)
  }

  @PostMapping
  fun customerSave(@RequestBody @Valid customerForm: CustomerForm) {
    this.customerService.save(customerForm)
  }
}