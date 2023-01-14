package com.itmo.microservices.demo.payment.api.service


import com.itmo.microservices.demo.payment.api.model.PaymentModel
import com.itmo.microservices.demo.payment.api.model.TransactionStatus
import java.util.*

interface PaymentService {
    fun allTransactions(): List<PaymentModel>
    fun changeTransactionStatus(paymentId: UUID, newStatus: TransactionStatus)
    fun addTransaction(payment: PaymentModel)
    fun deleteTransaction(paymentId: UUID)
}