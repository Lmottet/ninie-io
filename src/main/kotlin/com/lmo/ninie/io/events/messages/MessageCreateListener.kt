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
import discord4j.discordjson.json.MessageData
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    val respondableMapperService: RespondableMapperService,
    val aliasService: AliasService,
    val botConfigurationProperties: BotConfigurationProperties
) : EventListener<MessageCreateEvent>() {

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>) = event.map { execute(it.message) }
        .block()
        ?.map { }

    private fun execute(message: Message): Mono<*> =
        when {
            message.callsNinie(botConfigurationProperties.prefix) -> executeCommand(message) ?: Mono.empty<Unit>()
            !message.isBotAuthor() -> executeReaction(message)
            else -> Mono.empty<Unit>()
        }

    private fun executeCommand(message: Message) =
        aliasService.mapToCommand(findAlias(message))
            .respondTo(message)

    private fun executeReaction(message: Message): Mono<MessageData> =
        respondableMapperService.reactToCreation(message)

    private fun findAlias(message: Message): Alias =
        aliasService.find(message.extractCommandAlias()) ?: Alias.Unknown

}