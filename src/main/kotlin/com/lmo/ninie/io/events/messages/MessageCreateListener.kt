package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.events.EventListener
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageCreateEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener : MessageListener, EventListener<MessageCreateEvent> {

    @Value("\${bot.prefix}")
    val prefix = ""

    override fun getEventType(): Class<MessageCreateEvent> {
        return MessageCreateEvent::class.java
    }

    override fun execute(event: MessageCreateEvent): Mono<Message> {
        return processEvent(event.message, prefix)
    }
}