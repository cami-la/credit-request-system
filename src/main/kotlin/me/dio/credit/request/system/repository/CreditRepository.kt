package me.dio.credit.request.system.repository

import me.dio.credit.request.system.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
}