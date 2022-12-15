package com.itmo.microservices.demo.cart.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.itmo.microservices.demo.cart.api.model.PaymentStatus
import java.util.UUID


@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaymentModel(
    val timestamp: Long,
    val status: PaymentStatus,
    val amount: Int,
    val transactionId: UUID,
    )