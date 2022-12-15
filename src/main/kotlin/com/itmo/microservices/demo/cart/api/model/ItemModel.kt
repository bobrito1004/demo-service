package com.itmo.microservices.demo.cart.api.model

import java.util.UUID

data class ItemModel(
    val id: UUID,
    val title: String,
    val price: Int?,
)
