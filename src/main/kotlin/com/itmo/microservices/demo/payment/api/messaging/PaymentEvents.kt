package com.itmo.microservices.demo.payment.api.messaging

import com.itmo.microservices.demo.payment.api.model.PaymentModel

data class PaymentCreatedEvent(val payment: PaymentModel)


data class PaymentDeletedEvent(val payment: PaymentModel)