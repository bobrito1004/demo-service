package com.itmo.microservices.demo.cart.impl.entity

import com.itmo.microservices.demo.cart.api.model.PaymentStatus
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class OrderPayments {
    @Id
    var id: UUID? = null
    var orderId: UUID? = null
    var timestamp: Long? = null
    var status: String? = null
    var amount: Int? = null
    var transactionId: UUID? = null

    constructor()

    constructor(orderId: UUID?, status: PaymentStatus?, amount: Int?, transactionId: UUID?){
        this.id = UUID.randomUUID()
        this.orderId = orderId
        this.timestamp = System.currentTimeMillis()
        this.status = status.toString()
        this.amount = amount
        this.transactionId = transactionId
    }
}