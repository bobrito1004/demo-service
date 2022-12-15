package com.itmo.microservices.demo.cart.api.service

import com.itmo.microservices.demo.cart.api.model.OrderModel
import java.util.*

interface CartService {
    fun getOrder(order: UUID) : OrderModel?
    fun getAllOrders() : List<OrderModel>?
    fun createOrder(order: OrderModel)
}