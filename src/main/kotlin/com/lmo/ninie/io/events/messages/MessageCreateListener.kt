package com.lmo.ninie.io.events.messages

import com.lmo.ninie.io.commands.Alias
import com.lmo.ninie.io.events.EventListener
import com.lmo.ninie.io.extensions.eventmessage.callsNinie
import com.lmo.ninie.io.extensions.eventmessage.extractCommandAlias
import com.lmo.ninie.io.extensions.eventmessage.isBotAuthor
import com.lmo.ninie.io.services.commands.AliasService
import com.lmo.ninie.io.services.reactions.RespondableMapperService
import discord4j.core.`object`.entity.Message
import discord4j.core.event.domain.message.MessageCreateEvent
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MessageCreateListener(
    val respondableMapperService: RespondableMapperService,
    val aliasService: AliasService,
    @Value("bot.prefix") val prefix: String
) : EventListener<MessageCreateEvent> {

    override fun getEventType(): Class<MessageCreateEvent> = MessageCreateEvent::class.java

    override fun execute(event: Mono<MessageCreateEvent>): Mono<Unit>? = event.map { execute(it.message) }
        .block()
        ?.map { }

    private fun execute(message: Message) =
        when {
            message.callsNinie(prefix) -> executeCommand(message)
            !message.isBotAuthor() -> executeReaction(message)
            else -> Mono.empty()
        }

    private fun executeCommand(message: Message): Mono<Unit> =
        findAlias(message)
            .map { alias -> aliasService.mapToCommand(alias) }
            .get()
            .respondTo(message)
            .get()
            .map { }

    private fun executeReaction(message: Message): Mono<Unit> =
        respondableMapperService.reactToCreation(message)

    private fun findAlias(message: Message): Option<Alias> =
        aliasService.find(message.extractCommandAlias())
            .getOrElse(Alias.Unknown())
            .option()


}