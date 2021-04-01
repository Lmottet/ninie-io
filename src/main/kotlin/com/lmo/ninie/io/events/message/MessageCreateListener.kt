package com.lmo.ninie.io.events.message

import com.lmo.ninie.io.events.EventListener
import discord4j.core.event.domain.message.MessageCreateEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener : MessageListener, EventListener<MessageCreateEvent> {
    override fun getEventType(): Class<MessageCreateEvent> {
        return MessageCreateEvent::class.java
    }

    override fun execute(event: MessageCreateEvent): Mono<Unit> {
        return processEvent(event.message)
    }
}