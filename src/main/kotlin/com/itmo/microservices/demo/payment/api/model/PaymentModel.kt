package com.itmo.microservices.demo.payment.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaymentModel(
    val id: UUID?,
    val providerId: UUID?,
    val amount: BigDecimal?,
    val referenceNumber: String?,
    val account: String?,
    val transactionId: String?,
    val status: TransactionStatus?,
)