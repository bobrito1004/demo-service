package com.itmo.microservices.demo.cart.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.itmo.microservices.demo.cart.api.CartAggregate
import ru.quipy.core.*
import ru.quipy.database.EventStore
import ru.quipy.mapper.EventMapper
import ru.quipy.mapper.JsonEventMapper
import java.util.UUID

class CartEventService {
    var serv = EventSourcingServiceFactory(
        SeekingForSuitableClassesAggregateRegistry(
            BasicAggregateRegistry(),
            EventSourcingProperties(autoScanEnabled = true, scanPackage = "com.itmo.microservices.cart")),
        JsonEventMapper(ObjectMapper()),
        CartDBStore(),
        EventSourcingProperties(autoScanEnabled = true, scanPackage = "com.itmo.microservices.cart")
    ).create<UUID, CartAggregate, CartAggregateState>()
}


