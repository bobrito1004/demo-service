package com.itmo.microservices.demo.cart.impl

import ru.quipy.database.EventStore
import ru.quipy.domain.ActiveEventStreamReader
import ru.quipy.domain.EventRecord
import ru.quipy.domain.EventStreamReadIndex
import ru.quipy.domain.Snapshot

class CartDBStore : EventStore {
    override fun commitStreamReadIndex(readIndex: EventStreamReadIndex) {
        TODO("Not yet implemented")
    }

    override fun findBatchOfEventRecordAfter(
        aggregateTableName: String,
        eventSequenceNum: Long,
        batchSize: Int
    ): List<EventRecord> {
        TODO("Not yet implemented")
    }

    override fun findEventRecordsWithAggregateVersionGraterThan(
        aggregateTableName: String,
        aggregateId: Any,
        aggregateVersion: Long
    ): List<EventRecord> {
        TODO("Not yet implemented")
    }

    override fun findSnapshotByAggregateId(snapshotsTableName: String, aggregateId: Any): Snapshot? {
        TODO("Not yet implemented")
    }

    override fun findStreamReadIndex(streamName: String): EventStreamReadIndex? {
        TODO("Not yet implemented")
    }

    override fun getActiveStreamReader(streamName: String): ActiveEventStreamReader? {
        TODO("Not yet implemented")
    }

    override fun insertEventRecord(aggregateTableName: String, eventRecord: EventRecord) {
        TODO("Not yet implemented")
    }

    override fun insertEventRecords(aggregateTableName: String, eventRecords: List<EventRecord>) {
        TODO("Not yet implemented")
    }

    override fun tableExists(aggregateTableName: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateSnapshotWithLatestVersion(tableName: String, snapshot: Snapshot) {
        TODO("Not yet implemented")
    }
}