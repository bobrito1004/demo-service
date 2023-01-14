package com.itmo.microservices.demo.cart.impl.service

import com.google.common.eventbus.EventBus
import com.itmo.microservices.commonlib.annotations.InjectEventLogger
import com.itmo.microservices.commonlib.logging.EventLogger
import com.itmo.microservices.demo.cart.api.model.OrderModel
import com.itmo.microservices.demo.cart.api.model.OrderStatus
import com.itmo.microservices.demo.cart.api.service.CartService
import com.itmo.microservices.demo.cart.impl.repository.CartRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class DefaultCartService(
    private val cartRepository: CartRepository,
    private val eventBus: EventBus
) : CartService {
    @InjectEventLogger
    private lateinit var eventLogger: EventLogger

    override fun getOrder(order: UUID): OrderModel? {
        return OrderModel(UUID.randomUUID(),System.currentTimeMillis(), OrderStatus.COLLECTING,
            mutableMapOf(),  1, mutableListOf()
        )
    }

    override fun getAllOrders(): List<OrderModel>? {
        return listOf()
    }

    override fun createOrder(order: OrderModel) {
      TODO()
    }


}