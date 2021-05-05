package com.lmo.ninie.io.services.events.messages

import com.lmo.ninie.io.services.events.EventListener
import com.lmo.ninie.io.interactions.reactions.RespondableMapperService
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageUpdateEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageUpdateListener(
    val respondableMapperService: RespondableMapperService
) : EventListener<MessageUpdateEvent> {
    override fun getEventType(): Class<MessageUpdateEvent> = MessageUpdateEvent::class.java

    override fun execute(event: Mono<MessageUpdateEvent>): Mono<Unit>? = event.map { it.message.block() }
        .map { execute(it) }
        .block()
        ?.map { }

    private fun execute(message: Message?): Mono<Unit> {
        return if (null == message) Mono.empty() else respondableMapperService.reactToUpdate(message)
    }
}