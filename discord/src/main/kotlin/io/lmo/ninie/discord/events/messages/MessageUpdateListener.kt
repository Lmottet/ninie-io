package io.lmo.ninie.discord.events.messages

import discord4j.core.`object`.emoji.UnicodeEmoji
import discord4j.core.event.domain.message.MessageUpdateEvent
import io.lmo.ninie.discord.eventmessage.isBotAuthor
import io.lmo.ninie.discord.events.EventListener
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageUpdateListener : EventListener<MessageUpdateEvent>() {

    override fun getEventType(): Class<MessageUpdateEvent> = MessageUpdateEvent::class.java

    override fun execute(event: Mono<MessageUpdateEvent>): Mono<Unit> =
        event
            .flatMap { it.message }
            .filter { !it.isBotAuthor() }
            .flatMap { message -> message.addReaction(UnicodeEmoji.of("👀")).map { } }
}
