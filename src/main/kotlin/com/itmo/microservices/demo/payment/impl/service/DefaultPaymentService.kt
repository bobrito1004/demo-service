package com.itmo.microservices.demo.payment.impl.service

import com.google.common.eventbus.EventBus
import com.itmo.microservices.commonlib.annotations.InjectEventLogger
import com.itmo.microservices.commonlib.logging.EventLogger
import com.itmo.microservices.demo.payment.api.messaging.PaymentCreatedEvent
import com.itmo.microservices.demo.payment.api.messaging.PaymentDeletedEvent
import com.itmo.microservices.demo.payment.api.model.PaymentModel
import com.itmo.microservices.demo.payment.api.model.TransactionStatus
import com.itmo.microservices.demo.payment.api.service.PaymentService
import com.itmo.microservices.demo.payment.impl.logger.PaymentNotableService
import com.itmo.microservices.demo.payment.impl.repository.PaymentEntityRepository
import com.itmo.microservices.demo.payment.impl.util.toEntity
import com.itmo.microservices.demo.payment.impl.util.toModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*


@Service
@Suppress("UnstableApiUsage")
class DefaultPaymentService(
    private val paymentEntityRepository: PaymentEntityRepository,
    private val eventBus: EventBus
) : PaymentService {

    @InjectEventLogger
    private lateinit var eventLogger: EventLogger
    override fun allTransactions(): List<PaymentModel> = paymentEntityRepository.findAll()
        .map { it.toModel() }

    override fun changeTransactionStatus(paymentId: UUID, newStatus: TransactionStatus) {
        val paymentEntity = paymentEntityRepository.getReferenceById(paymentId)
        paymentEntity.status = newStatus
        paymentEntityRepository.saveAndFlush(paymentEntity)
    }

    override fun addTransaction(payment: PaymentModel) {
        val entity = payment.toEntity()
        paymentEntityRepository.save(entity)
        eventBus.post(PaymentCreatedEvent(entity.toModel()))
        eventLogger.info(
            PaymentNotableService.I_TRANSACTION_CREATED,
            entity
        )
    }

    override fun deleteTransaction(paymentId: UUID) {
        val payment = paymentEntityRepository.findByIdOrNull(paymentId) ?: return
        paymentEntityRepository.deleteById(paymentId)
        eventBus.post(PaymentDeletedEvent(payment.toModel()))
        eventLogger.info(
            PaymentNotableService.I_TRANSACTION_DELETED,
            payment
        )
    }

}