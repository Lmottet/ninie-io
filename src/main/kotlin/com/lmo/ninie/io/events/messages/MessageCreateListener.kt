package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.configurations.BotConfigurationProperties
import com.lmo.ninie.io.interactions.commands.Alias
import com.lmo.ninie.io.events.EventListener
import com.lmo.ninie.io.extensions.eventmessage.callsNinie
import com.lmo.ninie.io.extensions.eventmessage.extractCommandAlias
import com.lmo.ninie.io.extensions.eventmessage.isBotAuthor
import com.lmo.ninie.io.services.AliasService
import com.lmo.ninie.io.interactions.RespondableMapperService
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageCreateEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    private val respondableMapperService: RespondableMapperService,
    private val aliasService: AliasService,
    private val botConfigurationProperties: BotConfigurationProperties
) : EventListener<MessageCreateEvent>() {

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>): Mono<*> {
        return event.flatMap { messageCreateEvent ->
            execute(messageCreateEvent.message)
        }
    }

    private fun execute(message: Message): Mono<*> {
        return when {
            message.callsNinie(botConfigurationProperties.prefix) -> aliasService.mapToCommand(findAlias(message)).respondTo(message)
            !message.isBotAuthor() -> respondableMapperService.reactToCreation(message)
            else -> Mono.empty<Unit>()
        }
    }

    private fun findAlias(message: Message): Alias {
        return aliasService.find(message.extractCommandAlias()) ?: Alias.Unknown
    }
}
