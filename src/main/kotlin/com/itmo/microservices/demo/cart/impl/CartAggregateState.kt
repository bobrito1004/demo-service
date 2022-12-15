package com.itmo.microservices.demo.cart.impl

import com.itmo.microservices.demo.cart.api.CartAggregate
import com.itmo.microservices.demo.cart.api.model.OrderModel
import com.itmo.microservices.demo.cart.api.model.OrderStatus
import com.itmo.microservices.demo.cart.api.model.PaymentModel
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.util.*

class CartAggregateState : AggregateState<String, CartAggregate>{
    private lateinit var CartId: String
    private var createdAt: Long = System.currentTimeMillis()
    private var updatedAt: Long = System.currentTimeMillis()

    private var orders = mutableMapOf<UUID, OrderModel>()

    override fun getId() = CartId

    @StateTransitionFunc
    fun orderCreatedApply(event: OrderCreatedEvent){
        orders[event.orderId] = OrderModel(
            event.id,
            event.createdAt,
            OrderStatus.COLLECTING,
            mutableMapOf<UUID, Int>(),
            0,
            mutableListOf<PaymentModel>()
        )
        updatedAt = event.createdAt
    }

    @StateTransitionFunc
    fun orderStatusUpdatedApply(event: OrderStatusUpdatedEvent){
        orders[event.orderId]?.status = event.status
        updatedAt = event.createdAt
    }
}