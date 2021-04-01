package com.lmo.ninie.io.events

import discord4j.core.event.domain.Event
import reactor.core.publisher.Mono

interface EventListener<T : Event> {
    fun getEventType(): Class<T>
    fun execute(event: T): Mono<Unit>
    fun handleError(error: Throwable): Mono<Nothing> {
        return Mono.empty()
    }
}