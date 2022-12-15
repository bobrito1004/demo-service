package com.itmo.microservices.demo.cart.impl.entity

import com.itmo.microservices.demo.cart.api.model.OrderStatus
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Order {
    @Id
    var id: UUID? = null
    var timeCreated: Long? = null
    var status: OrderStatus? = null
    var itemsMap: MutableMap<UUID, Int>? = null

}