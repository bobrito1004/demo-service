package com.itmo.microservices.demo.cart.impl.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class OrderItems {
    @Id
    var id: UUID? = null
    var orderId: UUID? = null
    var itemId: UUID? = null
    var amount: Int? = null

    constructor()

    constructor(orderId: UUID?, itemId: UUID?, amount: Int?) {
        this.id = UUID.randomUUID()
        this.orderId = orderId
        this.itemId = itemId
        this.amount = amount
    }
}