package com.itmo.microservices.demo.cart.impl.repository

import com.itmo.microservices.demo.cart.impl.entity.OrderPayments
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderPaymentsRepository : JpaRepository<OrderPayments, String> {
}