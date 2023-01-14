package com.itmo.microservices.demo.cart.api

import com.itmo.microservices.demo.cart.api.model.OrderStatus
import com.itmo.microservices.demo.cart.impl.OrderCreatedEvent
import com.itmo.microservices.demo.cart.impl.OrderStatusUpdatedEvent
import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate
import java.util.UUID

@AggregateType(aggregateEventsTableName = "cart")
class CartAggregate : Aggregate

fun CartAggregate.CreateOrderCommand(
    cartId: UUID,
    orderId: UUID = UUID.randomUUID()
): OrderCreatedEvent {
    return OrderCreatedEvent(
        orderId = orderId,
        createdAt = System.currentTimeMillis()
    )
}

fun CartAggregate.UpdateOrderStatusCommand(
    cartId: UUID,
    orderId: UUID,
    status: OrderStatus
): OrderStatusUpdatedEvent {
    return OrderStatusUpdatedEvent(
        orderId = orderId,
        status = status,
        createdAt = System.currentTimeMillis()
    )
}