package com.itmo.microservices.demo.cart.impl.entity

import com.itmo.microservices.demo.cart.api.model.OrderStatus
import com.itmo.microservices.demo.cart.api.model.PaymentModel
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Order {
    @Id
    var id: UUID? = null
    var timeCreated: Long? = null
    var status: OrderStatus? = null
    var deliveryDuration: Int? = null

    constructor()

    constructor(id: UUID?, timeCreated: Long?,
                status: OrderStatus?, deliveryDuration: Int?){
        this.id = id
        this.timeCreated = timeCreated
        this.status = status
        this.deliveryDuration = deliveryDuration
    }

}