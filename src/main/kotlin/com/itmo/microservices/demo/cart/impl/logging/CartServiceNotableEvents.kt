package com.itmo.microservices.demo.cart.impl.logging

import com.itmo.microservices.commonlib.logging.NotableEvent

enum class CartServiceNotableEvents(private val template: String) : NotableEvent {
    ORDER_CREATED_EVENT("Order created: {}"),
    ORDER_UPDATED_EVENT("Order updated: {}");

    override fun getTemplate(): String {
        return template
    }

    override fun getName(): String {
        return name
    }

}