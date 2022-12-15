package com.itmo.microservices.demo.cart.api.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderModel(
    val id: UUID = UUID.randomUUID(),
    val timeCreated: Long,
    var status: OrderStatus,
    var itemsMap: MutableMap<UUID, Int>,
    var deliveryDuration: Int?,
    var paymentHistory: MutableList<PaymentModel>
)