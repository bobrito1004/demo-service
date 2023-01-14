package com.itmo.microservices.demo.payment.impl.entity


import com.itmo.microservices.demo.payment.api.model.TransactionStatus
import java.math.BigDecimal
import java.util.*
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id



@Entity
class PaymentEntity {
    @Id
    @GeneratedValue
    var id: UUID? = null
    var providerId: UUID? = null
    var amount: BigDecimal? = null
    var referenceNumber: String? = null
    var account: String? = null
    var transactionId: String? = null
    var status: TransactionStatus? = null

    constructor()

    constructor(id: UUID?, providerId: UUID?, amount: BigDecimal?, referenceNumber: String?, account: String?, transactionId: String?, status: TransactionStatus?) {
        this.id = id
        this.providerId = providerId
        this.amount = amount
        this.referenceNumber = referenceNumber
        this.account = account
        this.transactionId = transactionId
        this.status = status
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PaymentEntity

        if (id != other.id) return false
        if (providerId != other.providerId) return false
        if (amount != other.amount) return false
        if (referenceNumber != other.referenceNumber) return false
        if (account != other.account) return false
        if (transactionId != other.transactionId) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (providerId?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (referenceNumber?.hashCode() ?: 0)
        result = 31 * result + (account?.hashCode() ?: 0)
        result = 31 * result + (transactionId?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }


}