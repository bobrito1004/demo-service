package com.itmo.microservices.demo.payment.impl.logger

import com.itmo.microservices.commonlib.logging.NotableEvent

enum class PaymentNotableService(private val template: String) : NotableEvent {
    I_TRANSACTION_CREATED("Transaction created: {}"),
    I_TRANSACTION_DELETED("Transaction deleted: {}");

    override fun getTemplate(): String {
        return template
    }

    override fun getName(): String {
        return name
    }
}