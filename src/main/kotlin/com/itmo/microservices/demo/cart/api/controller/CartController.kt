package com.itmo.microservices.demo.cart.api.controller

import com.itmo.microservices.demo.cart.api.CartAggregate
import com.itmo.microservices.demo.cart.api.model.OrderModel
import com.itmo.microservices.demo.cart.api.service.CartService
import com.itmo.microservices.demo.cart.impl.CartAggregateState
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.quipy.core.EventSourcingService
import java.util.UUID


@RestController
@RequestMapping("/orders")
class CartController (private val cartService: CartService){
    @PostMapping
    @Operation(
        summary = "Create Order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Bad request", responseCode = "400", content = [Content()])
        ]
    )
    fun createOrder(@RequestBody request: OrderModel) = cartService.createOrder(request)

    @GetMapping("{orderId}")
    @Operation(
        summary = "Get Order",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Bad request", responseCode = "400", content = [Content()])
        ]
    )
    fun getOrder(@PathVariable orderId: UUID) = cartService.getOrder(orderId)

    @GetMapping()
    @Operation(
        summary = "Get all orders",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Bad request", responseCode = "400", content = [Content()])
        ]
    )
    fun getAllOrders() = cartService.getAllOrders()
}