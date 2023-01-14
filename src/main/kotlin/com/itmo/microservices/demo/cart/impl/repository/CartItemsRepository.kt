package com.itmo.microservices.demo.cart.impl.repository

import com.itmo.microservices.demo.cart.impl.entity.OrderItems
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartItemsRepository : JpaRepository<OrderItems, String> {
}