package com.itmo.microservices.demo.cart.impl

import com.itmo.microservices.demo.cart.api.CartAggregate
import com.itmo.microservices.demo.cart.api.model.OrderStatus
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*


@DomainEvent(name = "ORDER_CREATED_EVENT")
class OrderCreatedEvent(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<CartAggregate>(
    name = "ORDER_CREATED_EVENT",
    createdAt = createdAt
)

@DomainEvent(name = "ORDER_STATUS_UPDATED_EVENT")
class OrderStatusUpdatedEvent(
    val orderId: UUID,
    val status: OrderStatus,
    createdAt: Long = System.currentTimeMillis(),
) : Event<CartAggregate>(
    name = "ORDER_UPDATED_EVENT",
    createdAt = createdAt
)

