package com.lmo.ninie.io.events

import com.lmo.ninie.io.LoggerDelegate
import discord4j.core.event.domain.Event
import reactor.core.publisher.Mono

abstract class EventListener<T : Event> {

    private val logger by LoggerDelegate()

    abstract fun getEventType(): Class<T>

    abstract fun execute(event: Mono<T>): Mono<*>?

    fun handleError(error: Throwable): Mono<Nothing> {
        logger.error("Event process failed", error)
        return Mono.empty()
    }
}
