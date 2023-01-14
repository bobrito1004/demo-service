package com.itmo.microservices.demo.payment.impl.repository

import com.itmo.microservices.demo.payment.impl.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PaymentEntityRepository : JpaRepository<PaymentEntity, UUID> {
    override fun <S : PaymentEntity> saveAndFlush(entity: S): S
}