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
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.beans.factory.annotation.Value
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
        ?.map {  }

    private fun execute(message: Message): Mono<*> =
        when {
            message.callsNinie(botConfigurationProperties.prefix) -> executeCommand(message)
            !message.isBotAuthor() -> executeReaction(message)
            else ->  Mono.empty<Unit>()
        }

    private fun executeCommand(message: Message) =
        findAlias(message)
            .map { aliasService.mapToCommand(it) }
            .get()
            .respondTo(message)
            .onEmpty { /*log.info("")*/ }
            .getOrElse(Mono.empty())

    private fun executeReaction(message: Message): Mono<Unit> =
        respondableMapperService.reactToCreation(message)

    private fun findAlias(message: Message): Option<Alias> =
        aliasService.find(message.extractCommandAlias())
            .getOrElse(Alias.Unknown)
            .option()

}