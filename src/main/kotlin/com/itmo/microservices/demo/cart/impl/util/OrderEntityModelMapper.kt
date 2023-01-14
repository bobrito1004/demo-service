package com.itmo.microservices.demo.cart.impl.util

import com.itmo.microservices.demo.cart.api.model.OrderModel
import com.itmo.microservices.demo.cart.api.model.PaymentModel
import com.itmo.microservices.demo.cart.impl.entity.Order
import com.itmo.microservices.demo.cart.impl.repository.CartItemsRepository
import java.util.*

fun OrderModel.toEntity(): Order = Order(
    id = this.id,
    timeCreated = this.timeCreated,
    status = this.status,
    deliveryDuration = this.deliveryDuration
)

fun Order.toModel(cartItemsRepository: CartItemsRepository): OrderModel = OrderModel(
    id = this.id,
    timeCreated = this.timeCreated,
    status = this.status,
    itemsMap = mutableMapOf<UUID, Int>(),
    deliveryDuration = this.deliveryDuration,
    paymentHistory = mutableListOf<PaymentModel>()
)