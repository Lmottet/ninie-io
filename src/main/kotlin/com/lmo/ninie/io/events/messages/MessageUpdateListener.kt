package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.events.EventListener
import com.lmo.ninie.io.interactions.RespondableMapperService
import discord4j.core.event.domain.message.MessageUpdateEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageUpdateListener(
    private val respondableMapperService: RespondableMapperService
) : EventListener<MessageUpdateEvent>() {

    override fun getEventType(): Class<MessageUpdateEvent> = MessageUpdateEvent::class.java

    override fun execute(event: Mono<MessageUpdateEvent>): Mono<Unit> {
        return event
            .flatMap { it.message }
            .flatMap { message ->
                respondableMapperService.reactToUpdate(message)
            }
            .switchIfEmpty(Mono.empty())
    }
}
