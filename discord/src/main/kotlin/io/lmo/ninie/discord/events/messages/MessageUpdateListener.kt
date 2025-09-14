package io.lmo.ninie.discord.events.messages

import discord4j.core.event.domain.message.MessageUpdateEvent
import io.lmo.ninie.discord.events.EventListener
import io.lmo.ninie.discord.interactions.RespondableMapperService
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
