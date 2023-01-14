package com.itmo.microservices.demo.payment.impl.util

import com.itmo.microservices.demo.payment.api.model.PaymentModel
import com.itmo.microservices.demo.payment.impl.entity.PaymentEntity

fun PaymentModel.toEntity(): PaymentEntity = PaymentEntity(
    id = this.id,
    providerId = this.providerId,
    amount = this.amount,
    referenceNumber = this.referenceNumber,
    account = this.account,
    transactionId = this.transactionId,
    status = this.status,
)

fun PaymentEntity.toModel(): PaymentModel = PaymentModel(
    id = this.id,
    providerId = this.providerId,
    amount = this.amount,
    referenceNumber = this.referenceNumber,
    account = this.account,
    transactionId = this.transactionId,
    status = this.status,
)